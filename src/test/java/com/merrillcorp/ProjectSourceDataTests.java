package com.merrillcorp;

import com.merrillcorp.enterprise.canonical.models.ProjectSourceData;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProjectSourceDataTests {
    @Test
    public void isInContinuationIsTrue_WhenDateIsToday() {

        ProjectSourceData projectSourceData = new ProjectSourceData();

        projectSourceData.setContinuationDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        assertTrue("InContinuation should be true when the continuation date is today.", projectSourceData.isInContinuation());
    }

    @Test
    public void isInContinuationIsFalse_WhenDateIsAfterCurrentDate() {

        ProjectSourceData projectSourceData = new ProjectSourceData();
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);

        projectSourceData.setContinuationDate(tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        assertFalse("InContinuation should be false when the continuation date is tomorrow.", projectSourceData.isInContinuation());
    }

    @Test
    public void isInContinuationIsFalse_WhenFieldIsNotSet() {

        ProjectSourceData projectSourceData = new ProjectSourceData();

        assertFalse("InContinuation should be false when the continuation date is blank.", projectSourceData.isInContinuation());
    }
}
