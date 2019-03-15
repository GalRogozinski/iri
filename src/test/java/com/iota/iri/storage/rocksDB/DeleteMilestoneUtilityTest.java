package com.iota.iri.storage.rocksDB;

import com.iota.iri.conf.TestnetConfig;
import com.iota.iri.model.Hash;
import com.iota.iri.model.HashFactory;
import com.iota.iri.model.IntegerIndex;
import com.iota.iri.model.StateDiff;
import com.iota.iri.model.persistables.*;
import com.iota.iri.service.milestone.LatestMilestoneTracker;
import com.iota.iri.storage.Indexable;
import com.iota.iri.storage.Persistable;
import com.iota.iri.utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeleteMilestoneUtilityTest {

    private static RocksDBPersistenceProvider rocksDBPersistenceProvider;
    private static String dbPath = "testnetdb", dbLogPath = "milestonedeletelog";

    @BeforeClass
    public static void setUpDb() {
        rocksDBPersistenceProvider = new RocksDBPersistenceProvider(dbPath, dbLogPath, 10000);
        rocksDBPersistenceProvider.init();
    }

    @AfterClass
    public static void tearDown() {
        rocksDBPersistenceProvider.shutdown();
    }

    @Test
    public void deleteMilestone() throws Exception {
        Indexable hash1 = HashFactory.TRANSACTION.create("XTAKKEXASAOXQPMWUJWHWPNYVWRPASYUFVVXQGGYXKTVJZARUCXIZVONNUKLO9OSVEIBOQTAXJZR9F999");
        Indexable hash2 = HashFactory.TRANSACTION.create("JDFDLDHNWTMALVJHQLI9ZJFWCWRLEBMH9OPHEWCNCPRLQAEOKNVKPOBXZWCBSJABIWLHXYVBWYC9IU999");
        Hash cooAddress = HashFactory.ADDRESS.create(TestnetConfig.Defaults.COORDINATOR_ADDRESS);
        Hash milestoneBundle = HashFactory.BUNDLE.create("ACDPJMQRDPRQYEUMPRMHPWAEABHHCBU9QDXETIQTKJH9FDAQYJHXMIC9EJSNZOTHVWYDHKGIAHZSMYXDW");

        cleanAggregates(hash1, hash2, cooAddress);

        List<Pair<Indexable, ? extends Class<? extends Persistable>>> persistPairs = new ArrayList<>();

        persistPairs.add(new Pair<>(hash1, Transaction.class));
        persistPairs.add(new Pair<>(hash2, Transaction.class));

        persistPairs.add(new Pair<>(new IntegerIndex(117254), Milestone.class));

        persistPairs.add(new Pair<>(hash1, StateDiff.class));

        persistPairs.add(new Pair<>(milestoneBundle, Bundle.class));

        persistPairs.add(new Pair<>(hash1, Approvee.class));
        persistPairs.add(new Pair<>(hash2, Approvee.class));

        persistPairs.add(new Pair<>(hash1, ObsoleteTag.class));
        persistPairs.add(new Pair<>(hash2, ObsoleteTag.class));

        persistPairs.add(new Pair<>(hash1, Tag.class));
        persistPairs.add(new Pair<>(hash2, Tag.class));

        rocksDBPersistenceProvider.deleteBatch(persistPairs);
    }

    private void cleanAggregates(Indexable hash1, Indexable hash2, Hash cooAddress) throws Exception {
        Address txsForAddress = (Address) rocksDBPersistenceProvider.get(Address.class,
                cooAddress);
        txsForAddress.set.remove(hash1);
        rocksDBPersistenceProvider.save(txsForAddress, cooAddress);

        Hash branchHash1 = HashFactory.TRANSACTION.create("PNPAZXHSUFMQPBZJCLONLIZX9MYVVZCHMUCWRDRGI9IVGLL9QEFIKNJQ9OJDYTVLYYWPHYHLXEHBOW999");
        Hash branchHash2 = HashFactory.TRANSACTION.create("KLLGYPLMBHMY9IJJPVXZCX9LWSKZKGYNHWHDA9GOIIHRBRVJIOSIBDRVPTZRTNMB9UMBRDKMOSFOMW999");

        Approvee approvers = (Approvee) rocksDBPersistenceProvider.get(Approvee.class, branchHash1);
        approvers.set.remove(hash1);
        approvers.set.remove(hash2);
        rocksDBPersistenceProvider.save(approvers, branchHash1);

        approvers = (Approvee) rocksDBPersistenceProvider.get(Approvee.class, branchHash2);
        approvers.set.remove(hash2);
        rocksDBPersistenceProvider.save(approvers, branchHash2);
    }

}
