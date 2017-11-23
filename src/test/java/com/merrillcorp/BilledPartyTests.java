/*package com.merrillcorp;

import com.merrillcorp.enterprise.canonical.models.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BilledPartyTests {
  private static Logger logger = LoggerFactory.getLogger(BilledPartyTests.class);

  /*

   
  @Test
  public void isNewAccountShouldReturnTrueWhenCurrencyIsDifferent() {
    ProjectSourceData projectSourceData = new ProjectSourceData();
    projectSourceData.setCurrency("USD");
    projectSourceData.setLegalEntity("MSP");

    BilledParty billedParty = new BilledParty();
    CrossRef setupCrossRef = new CrossRef();
    setupCrossRef.setIdentifierTypeKey("Aria_Acct");
    setupCrossRef.setQualifier1Value("GER");
    setupCrossRef.setQualifier2Value("MSP");
    setupCrossRef.setIdentifierValue("abcX123");
    billedParty.getSourceData().getCrossRefs().add(setupCrossRef);

    assertTrue("isNewAccount should be true", billedParty.isNewAccount(projectSourceData));
  }

  @Test
  public void isNewAccountShouldReturnFalse() {
    ProjectSourceData projectSourceData = new ProjectSourceData();
    projectSourceData.setCurrency("USD");
    projectSourceData.setLegalEntity("MSP");

    BilledParty billedParty = new BilledParty();
    CrossRef setupCrossRef = new CrossRef();
    setupCrossRef.setIdentifierTypeKey("Aria_Acct");
    setupCrossRef.setQualifier1Value("USD");
    setupCrossRef.setQualifier2Value("MSP");
    setupCrossRef.setIdentifierValue("abcX123");
    billedParty.getSourceData().getCrossRefs().add(setupCrossRef);

    assertFalse("isNewAccount should be false", billedParty.isNewAccount(projectSourceData));
  }

  @Test
  public void isNewAccountShouldReturnTrue() {
    BilledParty billedParty = new BilledParty();

    assertTrue("isNewAccount should be true", billedParty.isNewAccount(null));
  }

  @Test
  public void getBilledPartyOperation_ShouldBeUpdate() {
    BilledParty billedParty = new BilledParty();
    billedParty.setBillingSystemMasterPlanInstanceId("asdf");

    billedParty.setBilledPartyDirectives(null);
    BilledPartyDirective billedPartyDirective = billedParty.getBilledPartyDirective();

    assertEquals(BilledPartyOperation.UPDATE, billedPartyDirective.getBilledPartyOperation());
  }

  @Test
  public void getBilledPartyOperation_WhenNothingIsPopulated() {
    BilledParty billedParty = new BilledParty();

    billedParty.setBilledPartyDirectives(null);
    BilledPartyDirective billedPartyDirective = billedParty.getBilledPartyDirective();

    assertEquals(BilledPartyOperation.ADD, billedPartyDirective.getBilledPartyOperation());
  }

  @Test
  public void setBillingSystemMasterPlanInstanceId_WhenAriaMatchesUp() {
    ProjectSourceData projectSourceData = new ProjectSourceData();
    projectSourceData.setCurrency("USD");
    projectSourceData.setLegalEntity("MSP");

    BilledParty billedParty = new BilledParty();
    CrossRef setupCrossRef = new CrossRef();
    setupCrossRef.setIdentifierTypeKey("Aria_Acct");
    setupCrossRef.setQualifier1Value("USD");
    setupCrossRef.setQualifier2Value("MSP");
    setupCrossRef.setIdentifierValue("abcX123");
    billedParty.getSourceData().getCrossRefs().add(setupCrossRef);

    List<CrossRef> crossRefList = new ArrayList<>();
    CrossRef crossRef = new CrossRef();
    crossRef.setIdentifierTypeKey("Aria_MPI");
    crossRef.setQualifier1Value("abcX123");
    crossRef.setIdentifierValue("The AriaMPI");
    crossRefList.add(crossRef);

    billedParty.setBillingSystemMasterPlanInstanceId(projectSourceData, crossRefList);

    assertEquals("The AriaMPI", billedParty.getBillingSystemMasterPlanInstanceId());
  }

  @Test
  public void setBillingSystemMasterPlanInstanceId_WhenAriaDoesNotMatchUp() {
    ProjectSourceData projectSourceData = new ProjectSourceData();
    projectSourceData.setCurrency("USD");
    projectSourceData.setLegalEntity("MSP");

    BilledParty billedParty = new BilledParty();
    CrossRef setupCrossRef = new CrossRef();
    setupCrossRef.setIdentifierTypeKey("Aria_Acct");
    setupCrossRef.setQualifier1Value("USD");
    setupCrossRef.setQualifier2Value("MSP");
    setupCrossRef.setIdentifierValue("abcX123");
    billedParty.getSourceData().getCrossRefs().add(setupCrossRef);

    List<CrossRef> crossRefList = new ArrayList<>();
    CrossRef crossRef = new CrossRef();
    crossRef.setIdentifierTypeKey("");
    crossRef.setQualifier1Value("");
    crossRef.setIdentifierValue("");
    crossRefList.add(crossRef);

    billedParty.setBillingSystemMasterPlanInstanceId(projectSourceData, crossRefList);

    assertEquals("", billedParty.getBillingSystemMasterPlanInstanceId());
  }

  @Test
  public void activeLabel_IsSetCorrectlyWhenNothingIsSet() {
    BilledParty billedParty = new BilledParty();

    billedParty.determineActiveLabel(null);

    assertEquals(" ", billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getActiveLabel());
  }

  @Test
  public void setCloseDate_DoesNotSetWhenProjectStatusIsNotClosed() {

    ProjectSourceData projectSourceData = buildClosedSourceData();
    projectSourceData.setProjectStatus("Some Status That Isn't Closed");

    BilledParty billedParty = new BilledParty();

    billedParty.setCloseDate(projectSourceData);

    assertEquals("", billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getCloseDate());
  }

  @Test
  public void setCloseDate_IsSetWhenProjectStatusIsClosed() {

    ProjectSourceData projectSourceData = buildClosedSourceData();

    BilledParty billedParty = new BilledParty();

    billedParty.setCloseDate(projectSourceData);

    assertEquals(today(), billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getCloseDate());
  }

  private ProjectSourceData buildClosedSourceData() {
    ProjectSourceData sourceData = new ProjectSourceData();

    sourceData.setProjectStatus(ProjectStatus.CLOSED.projectStatus());

    return sourceData;
  }

  private String today() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date currentDate = new Date();

    return dateFormat.format(currentDate);
  }
}
*/