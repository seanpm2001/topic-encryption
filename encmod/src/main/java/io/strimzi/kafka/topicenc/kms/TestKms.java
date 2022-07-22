/*
 * Copyright Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.kafka.topicenc.kms;

import javax.crypto.SecretKey;

import io.strimzi.kafka.topicenc.enc.CryptoUtils;

/**
 * An implementation KeyMgtSystem which serves up a pre-defined key. For test
 * only.
 */
public class TestKms implements KeyMgtSystem {

    private static String TEST_KEY = "bfUup8fs92bnOHlghWXegCJleHhbnNaf31RZL0d6r/I=";

    SecretKey key;

    @Override
    public SecretKey getKey(String keyReference) {
        if (key == null) {
            key = createTestKey();
        }
        return key;
    }

    private SecretKey createTestKey() {
        return CryptoUtils.base64Decode(TEST_KEY);
    }
}