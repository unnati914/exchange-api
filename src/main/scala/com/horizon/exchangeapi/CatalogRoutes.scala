package com.horizon.exchangeapi

import javax.ws.rs._ // this does not have the PATCH method
import akka.actor.ActorSystem
import akka.event.{ Logging, LoggingAdapter }
import de.heikoseeberger.akkahttpjackson._

//import com.horizon.exchangeapi.tables._
//import org.json4s._
import slick.jdbc.PostgresProfile.api._

//import scala.collection.mutable.{HashMap => MutableHashMap}

// Provides routes for browsing the services and patterns in the IBM catalog
@Path("/v1/catalog")
class CatalogRoutes(implicit val system: ActorSystem) extends JacksonSupport with AuthenticationSupport {
  def db: Database = ExchangeApiApp.getDb
  lazy implicit val logger: LoggingAdapter = Logging(system, classOf[OrgsRoutes])
  //protected implicit def jsonFormats: Formats

  /*
  // ====== GET /catalog/services ================================
  val getCatalogServices =
    (apiOperation[GetServicesResponse]("getCatalogServices")
      summary("Returns services in the IBM catalog")
      description("""Returns public service definitions from orgs of the specified orgtype (default is IBM). Can be run by any user, node, or agbot.""")
      parameters(
      Parameter("id", DataType.String, Option[String]("Username of exchange user, or ID of the node or agbot. This parameter can also be passed in the HTTP Header."), paramType=ParamType.Query, required=false),
      Parameter("token", DataType.String, Option[String]("Password of exchange user, or token of the node or agbot. This parameter can also be passed in the HTTP Header."), paramType=ParamType.Query, required=false),
      Parameter("orgtype", DataType.String, Option[String]("Return services from orgs of this orgtype (default is IBM)"), paramType=ParamType.Query, required=false)
    )
      responseMessages(ResponseMessage(HttpCode.BADCREDS,"invalid credentials"), ResponseMessage(HttpCode.ACCESS_DENIED,"access denied"), ResponseMessage(HttpCode.NOT_FOUND,"not found"))
      )

  get("/catalog/services", operation(getCatalogServices)) ({
    authenticate().authorizeTo(TService(OrgAndId("*","*").toString),Access.READ_ALL_SERVICES)
    val resp = response
    val orgType = params.get("orgtype").getOrElse("IBM")

    val svcQuery = for {
        (_, svc) <- OrgsTQ.getOrgidsOfType(orgType) join ServicesTQ.rows on ((o, s) => {o === s.orgid && s.public})
      } yield svc

    db.run(svcQuery.result).map({ list =>
      logger.debug("GET /catalog/services result size: "+list.size)
      //logger.debug("GET /catalog/services result: "+list.toString())
      val services = new MutableHashMap[String,Service]
      if (list.nonEmpty) for (a <- list) services.put(a.service, a.toService)
      if (services.nonEmpty) resp.setStatus(HttpCode.OK)
      else resp.setStatus(HttpCode.NOT_FOUND)
      GetServicesResponse(services.toMap, 0)
    })
  })

  // ====== GET /catalog/patterns ================================
  val getCatalogPatterns =
    (apiOperation[GetPatternsResponse]("getCatalogPatterns")
      summary("Returns patterns in the IBM catalog")
      description("""Returns public pattern definitions from orgs of the specified orgtype (default is IBM). Can be run by any user, node, or agbot.""")
      parameters(
      Parameter("id", DataType.String, Option[String]("Username of exchange user, or ID of the node or agbot. This parameter can also be passed in the HTTP Header."), paramType=ParamType.Query, required=false),
      Parameter("token", DataType.String, Option[String]("Password of exchange user, or token of the node or agbot. This parameter can also be passed in the HTTP Header."), paramType=ParamType.Query, required=false),
      Parameter("orgtype", DataType.String, Option[String]("Return patterns from orgs of this orgtype (default is IBM)"), paramType=ParamType.Query, required=false)
    )
      responseMessages(ResponseMessage(HttpCode.BADCREDS,"invalid credentials"), ResponseMessage(HttpCode.ACCESS_DENIED,"access denied"), ResponseMessage(HttpCode.NOT_FOUND,"not found"))
      )

  get("/catalog/patterns", operation(getCatalogPatterns)) ({
    authenticate().authorizeTo(TPattern(OrgAndId("*","*").toString),Access.READ_ALL_PATTERNS)
    val resp = response
    val orgType = params.get("orgtype").getOrElse("IBM")

    val svcQuery = for {
      (_, svc) <- OrgsTQ.getOrgidsOfType(orgType) join PatternsTQ.rows on ((o, s) => {o === s.orgid && s.public})
    } yield svc

    db.run(svcQuery.result).map({ list =>
      logger.debug("GET /catalog/patterns result size: "+list.size)
      //logger.debug("GET /catalog/patterns result: "+list.toString())
      val patterns = new MutableHashMap[String,Pattern]
      if (list.nonEmpty) for (a <- list) patterns.put(a.pattern, a.toPattern)
      if (patterns.nonEmpty) resp.setStatus(HttpCode.OK)
      else resp.setStatus(HttpCode.NOT_FOUND)
      GetPatternsResponse(patterns.toMap, 0)
    })
  })

   */
}
