/*package com.merrillcorp;

import com.merrillcorp.enterprise.canonical.models.*;
import org.junit.Test;
import org.opensaml.xml.signature.P;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
 * For the large majority these are more simple tests, the edge cases probably haven't been hit well. The skeleton/setup
 * is hopefully created so one can copy and tailor for the edge case that needs to be tested.
 *
 * Some edge cases were not working when these were developed.
 
public class ProjectTests {
    /*

     

    @Test
    public void populateToBeBilledModelSetsBillingSystemAccountIdToNew() {
        Project project = buildProjectModel();

        project.populateToBeBilledModel();

        assertEquals("NEW", project.getBilledParties().get(0).getBillingSystemAccountId());
    }

    @Test
    public void determineUpdatePlanStatusIsTrue() {
        Project project = buildProjectModel();
        project.getSourceData().setUpdatePlanStatus("true");

        assertTrue(project.determineUpdatePlanStatus());
    }

    @Test
    public void determineUpdatePlanStatusIsFalse() {
        Project project = buildProjectModel();

        assertFalse(project.determineUpdatePlanStatus());
    }

    @Test
    public void projectDirectives() {
        Project project = buildProjectModel();

        ProjectDirective projectDirectives = project.getProjectDirective();

        assertTrue("NewToAria should be true", projectDirectives.getNewToAria());
        assertFalse("SplitBill should be false for a single billed party project", projectDirectives.getSplitBill());
        assertFalse(projectDirectives.getUpdatePlanStatus());
        assertEquals("Active", project.getProjectDirective().getToProjState());
        assertEquals("Build Period", project.getProjectDirective().getFromProjState());

        //It doesn't look like the logic has been built around this and wouldn't make sense to test it now
        //assertEquals("", project.getProjectDirective().getCurPendingProjState());

        assertEquals("FlowType should be NewSingle when NewToAria and !SplitBill", ProjectFlowType.NEWSINGLE, project.getProjectDirective().getFlowType());

        assertFalse("Proration should not be needed", project.getProjectDirective().getProrationNeeded());

        //Gotta love this error message. Hope it brings someone joy
        //assertTrue("We don't have much in this project, so of course this should be a Create in DSO :)", project.getProjectDirective().getCreateDSO());
        //assertFalse("We don't have much in this project, so of course this should be a Create in DSO :)", project.getProjectDirective().getUpdateDSO());

        assertTrue("ManualDataRoom should be true", project.getProjectDirective().getIsManualDataRoom());
    }

    @Test
    public void currentEntitlementsIsLookedUpCorrectly() {
        Project project = buildProjectModel();

        assertEquals("ACTIVE ONE", project.getBilledParties().get(0).getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().getCurrentEntitlement());
    }

    private Project buildProjectModel() {
        Project project = new Project();
        ProjectSourceData projectSourceData = new ProjectSourceData();
        projectSourceData.setProjectSfdcId("abcX123");
        projectSourceData.setProjectStatus("Active");
        projectSourceData.setRevenueSite("STP - Not Sure What Else");
        projectSourceData.setUnitOfMeasure("Page");
        projectSourceData.setLegalEntity("010 - MERRILL COMMUNICATIONS LLC");
        projectSourceData.setContractCustomer("Aaron Test, 123 electric ave    US, Billy Madison bm@adison.com.org");
        projectSourceData.setProductType("Asset Purchase");
        projectSourceData.setMinimumFee("1");
        projectSourceData.setTier1Rate(1d);
        projectSourceData.setTier1UpperLimit(5d);
        projectSourceData.setTier2Rate(2d);
        projectSourceData.setTier2UpperLimit(10d);
        projectSourceData.setTier3Rate(3d);
        projectSourceData.setTier3UpperLimit(15d);
        projectSourceData.setTier4Rate(4d);
        projectSourceData.setTier4UpperLimit(20d);
        projectSourceData.setTier5Rate(5d);
        project.setSourceData(projectSourceData);

        IntegrationMetadata integrationMetadata = new IntegrationMetadata();
        integrationMetadata.setLastCompletedProjectStatus("Build Period");

        project.setIntegrationMetadata(integrationMetadata);
        project.setProjectDirectives();
        BilledParty billedParty = new BilledParty();
        billedParty.getSourceData().getBillingAddress().setCountry("US");
        project.setBilledParties(Arrays.asList(billedParty));

        Entitlement entitlement1 = new Entitlement();
        entitlement1.setActiveEntitlements("ACTIVE ONE");
        entitlement1.setHibernationEntitlements("HIBERNATE ONE");
        entitlement1.setPendingCloseEntitlements("PENDING CLOSE ONE");
        entitlement1.setPreparationEntitlements("PREPARATION ONE");
        entitlement1.setSuspendedEntitlements("SUSPENDED ONE");
        Entitlement entitlement2 = new Entitlement();

        project.setEntitlements(new ArrayList<>(Arrays.asList(entitlement1, entitlement2)));


        return project;
    }
}
	*/