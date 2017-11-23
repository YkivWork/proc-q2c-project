/*package com.merrillcorp;

import com.merrillcorp.enterprise.canonical.models.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProjectSuppPlanStatusTests {
  @Test
  public void masterPlanStatus_WhenActiveAndNewSingle() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.ACTIVE);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.NEWSINGLE);

    assertNull(projectSuppPlanStatus.getMasterPlanStatus(projectDirective));
  }

  @Test
  public void masterPlanStatus_WhenActiveAndUpdatePlan() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.ACTIVE);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.UPDATEPLANSTATUS);

    assertEquals("1", projectSuppPlanStatus.getMasterPlanStatus(projectDirective));
  }

  @Test
  public void masterPlanStatus_WhenInHibernationAndUpdatePlan() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.HIBERNATION);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.UPDATEPLANSTATUS);

    assertEquals("1", projectSuppPlanStatus.getMasterPlanStatus(projectDirective));
  }

  @Test
  public void masterPlanStatus_WhenInHibernationAndNewSingle() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.HIBERNATION);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.NEWSINGLE);

    assertEquals("1", projectSuppPlanStatus.getMasterPlanStatus(projectDirective));
  }

  @Test
  public void getSuppPlanStatus_WhenNewSingle() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.HIBERNATION);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.NEWSINGLE);

    IntegrationMetadata metadata = new IntegrationMetadata();

    assertEquals("1", projectSuppPlanStatus.getSuppPlanStatus(projectDirective, metadata));

  }

  @Test
  public void getSuppPlanStatus_WhenInHibernationAndPriorWasClosureRequested() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.HIBERNATION);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.UPDATESINGLE);

    IntegrationMetadata metadata = new IntegrationMetadata();
    metadata.setLastCompletedProjectStatus(ProjectStatus.CLOSUREREQUEST.projectStatus());

    assertEquals("1", projectSuppPlanStatus.getSuppPlanStatus(projectDirective, metadata));
  }

  @Test
  public void getSuppPlanStatus_WhenPriorClosedAndInHibernation() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.HIBERNATION);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.UPDATESINGLE);

    IntegrationMetadata metadata = new IntegrationMetadata();
    metadata.setLastCompletedProjectStatus(ProjectStatus.CLOSED.projectStatus());

    assertEquals("1", projectSuppPlanStatus.getSuppPlanStatus(projectDirective, metadata));
  }

  @Test
  public void getSuppPlanStatus_WhenPriorBuildPeriodAndIsActive() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.ACTIVE);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.UPDATESINGLE);

    IntegrationMetadata metadata = new IntegrationMetadata();
    metadata.setLastCompletedProjectStatus(ProjectStatus.BUILDPERIOD.projectStatus());

    assertNull(projectSuppPlanStatus.getSuppPlanStatus(projectDirective, metadata));
  }

  @Test
  public void getSuppPlanStatus_WhenSuspended() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.SUSPENDED);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.UPDATESINGLE);

    IntegrationMetadata metadata = new IntegrationMetadata();
    metadata.setLastCompletedProjectStatus(ProjectStatus.BUILDPERIOD.projectStatus());

    assertEquals("-1", projectSuppPlanStatus.getSuppPlanStatus(projectDirective, metadata));
  }


  /*public void getSuppPlanStatus_WhenInContinuation() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.CONTINUATION);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.UPDATESINGLE);

    IntegrationMetadata metadata = new IntegrationMetadata();
    metadata.setLastCompletedProjectStatus(ProjectStatus.BUILDPERIOD.projectStatus());

    assertEquals("1", projectSuppPlanStatus.getSuppPlanStatus(projectDirective, metadata));
  }

  @Test
  public void getSuppPlanStatus_WhenInBuildPeriodAndWasSuspended() {
    ProjectSuppPlanStatus projectSuppPlanStatus = new ProjectSuppPlanStatus(ProjectStatus.BUILDPERIOD);

    ProjectDirective projectDirective = new ProjectDirective();
    projectDirective.setFlowType(ProjectFlowType.UPDATESINGLE);

    IntegrationMetadata metadata = new IntegrationMetadata();
    metadata.setLastCompletedProjectStatus(ProjectStatus.SUSPENDED.projectStatus());

    assertEquals("32", projectSuppPlanStatus.getSuppPlanStatus(projectDirective, metadata));
  }
}
*/