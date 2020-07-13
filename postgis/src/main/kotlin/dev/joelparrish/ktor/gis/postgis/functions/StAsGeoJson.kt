package dev.joelparrish.ktor.gis.postgis.functions

import dev.joelparrish.ktor.gis.postgis.columns.GeomColumnType
import org.jetbrains.exposed.sql.append
import org.jetbrains.exposed.sql.Expression
import org.jetbrains.exposed.sql.Function
import org.jetbrains.exposed.sql.QueryBuilder

class StAsGeoJson<T>(val geomExpr: Expression<T>) : Function<String>(GeomColumnType()) {
    override fun toQueryBuilder(queryBuilder: QueryBuilder) =
        queryBuilder { append("ST_AsGeoJSON(", geomExpr, ")") }
}