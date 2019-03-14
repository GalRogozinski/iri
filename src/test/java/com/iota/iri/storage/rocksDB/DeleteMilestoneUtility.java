package com.iota.iri.storage.rocksDB;

import com.iota.iri.model.Hash;
import com.iota.iri.model.HashFactory;
import com.iota.iri.model.persistables.Transaction;
import com.iota.iri.storage.Indexable;
import com.iota.iri.storage.Persistable;
import com.iota.iri.utils.Pair;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeleteMilestoneUtility {

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
        List<Pair<Indexable, ? extends Class<? extends Persistable>>> txPairs = Stream.of(hash1, hash2)
                .map(hash -> new Pair<>(hash, Transaction.class))
                .collect(Collectors.toList());
        rocksDBPersistenceProvider.deleteBatch(txPairs);
    }
}
