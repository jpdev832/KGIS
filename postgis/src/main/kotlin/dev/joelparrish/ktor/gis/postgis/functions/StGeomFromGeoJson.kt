package dev.joelparrish.ktor.gis.postgis.functions

import dev.joelparrish.ktor.gis.postgis.columns.GeomColumnType
import org.jetbrains.exposed.sql.Function
import org.jetbrains.exposed.sql.QueryBuilder
import org.jetbrains.exposed.sql.append

class StGeomFromGeoJson(private val geoJson: String) : Function<String>(GeomColumnType()) {
    override fun toQueryBuilder(queryBuilder: QueryBuilder) =
        queryBuilder { append("ST_GeomFromGeoJSON(", geoJson, ")") }
}