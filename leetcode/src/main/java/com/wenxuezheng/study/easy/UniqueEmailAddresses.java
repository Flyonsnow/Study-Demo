package com.wenxuezheng.study.easy;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 929 {@see https://leetcode.com/problems/unique-email-addresses/}
 * 2018-12-27 numUniqueEmails Accepted 50ms
 *
 * @author hubo
 * @since 2018-12-27
 */
public class UniqueEmailAddresses {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        Assert.assertEquals(numUniqueEmails(emails), 2);
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueMailSet = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            final String[] emailArr = emails[i].split("@");
            uniqueMailSet.add(emailArr[0].substring(0, emailArr[0].indexOf("+")).replaceAll(".", "") + emailArr[1]);
        }
        return uniqueMailSet.size();
    }

}
