/**
 * Generated by apidoc - http://www.apidoc.me
 * Service version: 0.0.4
 * apidoc:0.9.34 http://www.apidoc.me/gilt/cave-llc/0.0.4/scala_client_api
 */
package com.gilt.cavellc.models {

  /**
   * This entity describes a configured alert, what to check and how often.
   */
  case class Alert(
    id: _root_.scala.Option[String] = None,
    description: String,
    enabled: Boolean,
    period: String,
    condition: String,
    handbookUrl: _root_.scala.Option[String] = None,
    routing: _root_.scala.Option[Map[String, String]] = None,
    relatedMetrics: _root_.scala.Option[Seq[com.gilt.cavellc.models.AlertMetric]] = None
  )

  /**
   * Information about a metric related to an alert.
   */
  case class AlertMetric(
    name: String,
    tags: Map[String, String],
    aggregator: _root_.scala.Option[com.gilt.cavellc.models.Aggregator] = None,
    periodSeconds: _root_.scala.Option[Long] = None
  )

  /**
   * Authorization information for a user
   */
  case class Auth(
    token: String,
    expires: _root_.org.joda.time.DateTime
  )

  /**
   * An issue affecting CAVE right now, or recently closed
   */
  case class Issue(
    description: String,
    since: _root_.org.joda.time.DateTime,
    until: _root_.scala.Option[_root_.org.joda.time.DateTime] = None
  )

  /**
   * An organization or team user, with the role
   */
  case class Member(
    user: com.gilt.cavellc.models.User,
    role: com.gilt.cavellc.models.Role
  )

  /**
   * This entity encapsulates metric data that can be stored in CAVE.
   */
  case class Metric(
    name: String,
    tags: _root_.scala.Option[Map[String, String]] = None,
    timestamp: Long,
    value: Double
  )

  /**
   * This entity encapsulates a data point for a metric.
   */
  case class MetricData(
    time: _root_.org.joda.time.DateTime,
    value: Double
  )

  /**
   * This entity encapsulates data for a metric.
   */
  case class MetricDataBulk(
    metrics: Seq[com.gilt.cavellc.models.MetricData]
  )

  /**
   * This entity encapsulates information about a metric.
   */
  case class MetricInfo(
    name: String,
    tags: Seq[String]
  )

  /**
   * An organization is a real-world customer of the CAVE service. Each organization
   * is identified by a name, which must be unique. Each organization can have one or
   * more teams associated with it, allowing for data to be segregated. Security is
   * managed with organization tokens. A token is created automatically for every new
   * organization.
   */
  case class Organization(
    name: String,
    email: String,
    notificationUrl: String,
    tokens: Seq[com.gilt.cavellc.models.Token]
  )

  /**
   * The list of current and recent issues affecting CAVE
   */
  case class Status(
    current: Seq[com.gilt.cavellc.models.Issue],
    recent: Seq[com.gilt.cavellc.models.Issue]
  )

  /**
   * Each team has its own data. A team can push data into CAVE by using an active
   * token. A team can have one or more tokens associated with it, allowing for
   * tokens to be rotated, for security purposes. A team is solely responsible for
   * administration of its tokens. A team token is created automatically for every
   * new team.
   */
  case class Team(
    name: String,
    tokens: Seq[com.gilt.cavellc.models.Token]
  )

  /**
   * A token is a security string, used to authenticate requests. Some requests can
   * only be executed by the organization owner, and these must be authenticated with
   * an organization token. Other requests can only be executed by a team owner, and
   * these can be authenticated with either a team token, or an organization token.
   */
  case class Token(
    id: String,
    description: String,
    value: String,
    created: _root_.org.joda.time.DateTime
  )

  /**
   * A user is a real-world person who is using the CAVE service. The user signs up
   * for CAVE, and then interacts with the service through the APIs. Every call to
   * the API needs to use a token that is obtained after a successful login.
   */
  case class User(
    firstName: String,
    lastName: String,
    email: String
  )

  /**
   * An organization associated with a user.
   */
  case class UserOrganization(
    name: String,
    role: com.gilt.cavellc.models.Role
  )

  /**
   * A team associated with a user.
   */
  case class UserTeam(
    name: String,
    role: com.gilt.cavellc.models.Role
  )

  /**
   * An aggregator for metric data
   */
  sealed trait Aggregator

  object Aggregator {

    /**
     * The number of events in the metric data set.
     */
    case object Count extends Aggregator { override def toString = "count" }
    /**
     * The smallest value in the metric data set.
     */
    case object Min extends Aggregator { override def toString = "min" }
    /**
     * The largest value in the metric data set.
     */
    case object Max extends Aggregator { override def toString = "max" }
    /**
     * The average of the values in the metric data set.
     */
    case object Mean extends Aggregator { override def toString = "mean" }
    /**
     * The most frequent value in the metric data set.
     */
    case object Mode extends Aggregator { override def toString = "mode" }
    /**
     * The middle value in the metric data set.
     */
    case object Median extends Aggregator { override def toString = "median" }
    /**
     * The sum of all values in the metric data set.
     */
    case object Sum extends Aggregator { override def toString = "sum" }
    /**
     * The standard deviation of all values in the metric data set.
     */
    case object Stddev extends Aggregator { override def toString = "stddev" }
    /**
     * The 99th percentile value in the metric data set.
     */
    case object P99 extends Aggregator { override def toString = "p99" }
    /**
     * The 99.9th percentile value in the metric data set.
     */
    case object P999 extends Aggregator { override def toString = "p999" }
    /**
     * The 95th percentile value in the metric data set.
     */
    case object P95 extends Aggregator { override def toString = "p95" }
    /**
     * The 90th percentile value in the metric data set.
     */
    case object P90 extends Aggregator { override def toString = "p90" }

    /**
     * UNDEFINED captures values that are sent either in error or
     * that were added by the server after this library was
     * generated. We want to make it easy and obvious for users of
     * this library to handle this case gracefully.
     *
     * We use all CAPS for the variable name to avoid collisions
     * with the camel cased values above.
     */
    case class UNDEFINED(override val toString: String) extends Aggregator

    /**
     * all returns a list of all the valid, known values. We use
     * lower case to avoid collisions with the camel cased values
     * above.
     */
    val all = Seq(Count, Min, Max, Mean, Mode, Median, Sum, Stddev, P99, P999, P95, P90)

    private[this]
    val byName = all.map(x => x.toString.toLowerCase -> x).toMap

    def apply(value: String): Aggregator = fromString(value).getOrElse(UNDEFINED(value))

    def fromString(value: String): _root_.scala.Option[Aggregator] = byName.get(value.toLowerCase)

  }

  /**
   * The role that a user has in an organization or team
   */
  sealed trait Role

  object Role {

    /**
     * The administrator of the organization/team. Can do all operations.
     */
    case object Admin extends Role { override def toString = "admin" }
    /**
     * A member of the organization/team. Can do most operations.
     */
    case object Member extends Role { override def toString = "member" }
    /**
     * A read-only user of the organization/team. Can only view data.
     */
    case object Viewer extends Role { override def toString = "viewer" }
    /**
     * A user associated indirectly to an organization, through at least one team.
     */
    case object Team extends Role { override def toString = "team" }

    /**
     * UNDEFINED captures values that are sent either in error or
     * that were added by the server after this library was
     * generated. We want to make it easy and obvious for users of
     * this library to handle this case gracefully.
     *
     * We use all CAPS for the variable name to avoid collisions
     * with the camel cased values above.
     */
    case class UNDEFINED(override val toString: String) extends Role

    /**
     * all returns a list of all the valid, known values. We use
     * lower case to avoid collisions with the camel cased values
     * above.
     */
    val all = Seq(Admin, Member, Viewer, Team)

    private[this]
    val byName = all.map(x => x.toString.toLowerCase -> x).toMap

    def apply(value: String): Role = fromString(value).getOrElse(UNDEFINED(value))

    def fromString(value: String): _root_.scala.Option[Role] = byName.get(value.toLowerCase)

  }

}



package com.gilt.cavellc {

  object Constants {

    val UserAgent = "apidoc:0.9.34 http://www.apidoc.me/gilt/cave-llc/0.0.4/play_2_3_client"
    val Version = "0.0.4"
    val VersionMajor = 0

  }

  trait Alerts {
    /**
     * Retrieve the list of alerts associated with the given organization.
     */
    def getOrganizationsByOrganization(
      organization: String,
      limit: Int = 20,
      offset: Int = 0
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.Alert]]

    /**
     * Create a new alert for the given organization.
     */
    def postOrganizationsByOrganization(
      organization: String,
      description: String,
      enabled: Boolean,
      period: String,
      condition: String,
      handbookUrl: _root_.scala.Option[String] = None,
      routing: _root_.scala.Option[Map[String, String]] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Alert]

    /**
     * Update an alert for the given organization.
     */
    def patchOrganizationsByOrganizationAndId(
      organization: String,
      id: String,
      description: _root_.scala.Option[String] = None,
      enabled: _root_.scala.Option[Boolean] = None,
      period: _root_.scala.Option[String] = None,
      handbookUrl: _root_.scala.Option[String] = None,
      routing: _root_.scala.Option[Map[String, String]] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Alert]

    /**
     * Retrieve the alert with given alert ID for the given organization.
     */
    def getOrganizationsByOrganizationAndId(
      organization: String,
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Alert]

    /**
     * Delete the alert with the given ID from the given organization.
     */
    def deleteOrganizationsByOrganizationAndId(
      organization: String,
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Retrieve the list of alerts associated with the given team of the given
     * organization.
     */
    def getOrganizationsAndTeamsByOrganizationAndTeam(
      organization: String,
      team: String,
      limit: Int = 20,
      offset: Int = 0
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.Alert]]

    /**
     * Create a new alert for the given team of the given organization.
     */
    def postOrganizationsAndTeamsByOrganizationAndTeam(
      organization: String,
      team: String,
      description: String,
      enabled: Boolean,
      period: String,
      condition: String,
      handbookUrl: _root_.scala.Option[String] = None,
      routing: _root_.scala.Option[Map[String, String]] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Alert]

    /**
     * Update an alert for the given team of the given organization.
     */
    def patchOrganizationsAndTeamsByOrganizationAndTeamAndId(
      organization: String,
      team: String,
      id: String,
      description: _root_.scala.Option[String] = None,
      enabled: _root_.scala.Option[Boolean] = None,
      period: _root_.scala.Option[String] = None,
      handbookUrl: _root_.scala.Option[String] = None,
      routing: _root_.scala.Option[Map[String, String]] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Alert]

    /**
     * Retrieve the alert with given alert ID for the given team of the given
     * organization.
     */
    def getOrganizationsAndTeamsByOrganizationAndTeamAndId(
      organization: String,
      team: String,
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Alert]

    /**
     * Delete the alert with the given ID from the given team of the given
     * organization.
     */
    def deleteOrganizationsAndTeamsByOrganizationAndTeamAndId(
      organization: String,
      team: String,
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]
  }

  trait Metrics {
    /**
     * Create organization metric data.
     */
    def postOrganizationsByOrganization(
      organization: String,
      metrics: Seq[com.gilt.cavellc.models.Metric]
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Create team metric data.
     */
    def postOrganizationsAndTeamsByOrganizationAndTeam(
      organization: String,
      team: String,
      metrics: Seq[com.gilt.cavellc.models.Metric]
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Retrieve information about available organization metrics.
     */
    def getOrganizationsAndMetricNamesByOrganization(
      organization: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.MetricInfo]]

    /**
     * Retrieve information about available team metrics.
     */
    def getOrganizationsAndTeamsAndMetricNamesByOrganizationAndTeam(
      organization: String,
      team: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.MetricInfo]]

    /**
     * Evaluate data for organization metrics.
     */
    def getOrganizationsAndCheckMetricsByOrganization(
      organization: String,
      condition: String,
      start: _root_.org.joda.time.DateTime,
      end: _root_.scala.Option[_root_.org.joda.time.DateTime] = None,
      interval: _root_.scala.Option[Int] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.MetricDataBulk]

    /**
     * Evaluate data for team metrics.
     */
    def getOrganizationsAndTeamsAndCheckMetricsByOrganizationAndTeam(
      organization: String,
      team: String,
      condition: String,
      start: _root_.org.joda.time.DateTime,
      end: _root_.scala.Option[_root_.org.joda.time.DateTime] = None,
      interval: _root_.scala.Option[Int] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.MetricDataBulk]

    /**
     * Retrieve data for an organization metric.
     */
    def getOrganizationsByOrganization(
      organization: String,
      metric: String,
      tags: _root_.scala.Option[String] = None,
      aggregator: com.gilt.cavellc.models.Aggregator,
      period: Int,
      start: _root_.scala.Option[_root_.org.joda.time.DateTime] = None,
      end: _root_.scala.Option[_root_.org.joda.time.DateTime] = None,
      limit: Int = 60
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.MetricDataBulk]

    /**
     * Retrieve data for a team metric.
     */
    def getOrganizationsAndTeamsByOrganizationAndTeam(
      organization: String,
      team: String,
      metric: String,
      tags: _root_.scala.Option[String] = None,
      aggregator: com.gilt.cavellc.models.Aggregator,
      period: Int,
      start: _root_.scala.Option[_root_.org.joda.time.DateTime] = None,
      end: _root_.scala.Option[_root_.org.joda.time.DateTime] = None,
      limit: Int = 60
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.MetricDataBulk]
  }

  trait Organizations {
    /**
     * Create a new organization.
     */
    def post(
      name: String,
      email: String,
      notificationUrl: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Organization]

    /**
     * Retrieve organization with given name.
     */
    def getByName(
      name: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Organization]

    /**
     * Update the organization with the given name.
     */
    def patchByName(
      name: String,
      email: _root_.scala.Option[String] = None,
      notificationUrl: _root_.scala.Option[String] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Organization]

    /**
     * Delete the organization with the given name.
     */
    def deleteByName(
      name: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    def deleteMetricNamesByNameAndMetric(
      name: String,
      metric: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Retrieve organization users.
     */
    def getUsersByName(
      name: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.Member]]

    /**
     * Add user to organization.
     */
    def postUsersByName(
      name: String,
      email: String,
      role: com.gilt.cavellc.models.Role
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Modify role for user in organization.
     */
    def patchUsersByNameAndEmail(
      name: String,
      email: String,
      role: com.gilt.cavellc.models.Role
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Delete user from organization.
     */
    def deleteUsersByNameAndEmail(
      name: String,
      email: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]
  }

  trait Statuses {
    /**
     * Get list of current and recent issues affecting CAVE
     */
    def getStatus()(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Status]
  }

  trait Teams {
    /**
     * Retrieve the list of teams associated with the given organization.
     */
    def getOrganizationsByOrganization(
      organization: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.Team]]

    /**
     * Create a new team for the given organization.
     */
    def postOrganizationsByOrg(
      org: String,
      name: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Team]

    /**
     * Retrieve the team with given team name for the given organization.
     */
    def getOrganizationsByOrganizationAndTeam(
      organization: String,
      team: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Team]

    def deleteOrganizationsAndMetricNamesByOrganizationNameAndTeamNameAndMetric(
      organizationName: String,
      teamName: String,
      metric: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Retrieve the users for the team with given team name for the given organization.
     */
    def getOrganizationsAndUsersByOrganizationAndTeam(
      organization: String,
      team: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.Member]]

    /**
     * Add user to the team with given team name for the given organization.
     */
    def postOrganizationsAndUsersByOrganizationAndTeam(
      organization: String,
      team: String,
      email: String,
      role: com.gilt.cavellc.models.Role
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Modify role of user in team.
     */
    def patchOrganizationsAndUsersByOrganizationAndTeamAndEmail(
      organization: String,
      team: String,
      email: String,
      role: com.gilt.cavellc.models.Role
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Remove user from team.
     */
    def deleteOrganizationsAndUsersByOrganizationAndTeamAndEmail(
      organization: String,
      team: String,
      email: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Delete the team with the given name from the given organization.
     */
    def deleteOrganizationsByOrganizationAndTeam(
      organization: String,
      team: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]
  }

  trait Tokens {
    /**
     * Retrieve the list of tokens associated with the given organization.
     */
    def getOrganizationsByOrganization(
      organization: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.Token]]

    /**
     * Create a new token for the given organization.
     */
    def postOrganizationsByOrganization(
      organization: String,
      description: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Token]

    /**
     * Retrieve the token with given token ID for the given organization.
     */
    def getOrganizationsByOrganizationAndId(
      organization: String,
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Token]

    /**
     * Delete the token with the given ID from the given organization.
     */
    def deleteOrganizationsByOrganizationAndId(
      organization: String,
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Retrieve the list of tokens associated with the given team of the given
     * organization.
     */
    def getOrganizationsAndTeamsByOrganizationAndTeam(
      organization: String,
      team: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.Token]]

    /**
     * Create a new token for the given team of the given organization.
     */
    def postOrganizationsAndTeamsByOrganizationAndTeam(
      organization: String,
      team: String,
      description: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Token]

    /**
     * Retrieve the token with given token ID for the given team of the given
     * organization.
     */
    def getOrganizationsAndTeamsByOrganizationAndTeamAndId(
      organization: String,
      team: String,
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Token]

    /**
     * Delete the token with the given ID from the given team of the given
     * organization.
     */
    def deleteOrganizationsAndTeamsByOrganizationAndTeamAndId(
      organization: String,
      team: String,
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]
  }

  trait Users {
    /**
     * Register an email address for a new user
     */
    def postRegister(
      email: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Confirm an email address and complete user registration
     */
    def postConfirm(
      firstName: String,
      lastName: String,
      password: String,
      confirmationToken: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.User]

    /**
     * Authenticate a user for using the CAVE API
     */
    def postLogin(
      email: String,
      password: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.Auth]

    /**
     * Request password reset for a user
     */
    def postForgotPassword(
      email: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Reset the password for a user
     */
    def postResetPassword(
      password: String,
      token: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Retrieve user information
     */
    def getInfo()(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.User]

    /**
     * Update user information
     */
    def patchInfo(
      firstName: _root_.scala.Option[String] = None,
      lastName: _root_.scala.Option[String] = None,
      password: _root_.scala.Option[String] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.gilt.cavellc.models.User]

    /**
     * Retrieve organizations for this user
     */
    def getOrganizations()(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.UserOrganization]]

    /**
     * Retrieve teams in this organization for this user
     */
    def getOrganizationsAndTeamsByName(
      name: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.UserTeam]]

    /**
     * Search users that match the given substring
     */
    def getSearch(
      q: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.gilt.cavellc.models.User]]
  }

  package errors {

    case class FailedRequest(responseCode: Int, message: String, requestUri: Option[_root_.java.net.URI] = None) extends Exception(s"HTTP $responseCode: $message")

  }

}