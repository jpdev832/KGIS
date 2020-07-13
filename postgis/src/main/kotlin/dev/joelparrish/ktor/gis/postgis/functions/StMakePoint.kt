package dev.joelparrish.ktor.gis.postgis.functions

import dev.joelparrish.ktor.gis.postgis.columns.GeomColumnType
import org.jetbrains.exposed.sql.Function
import org.jetbrains.exposed.sql.QueryBuilder
import org.jetbrains.exposed.sql.append

/**
 * Creates a 2D, 3D Z or 4D ZM Point geometry
 */
class StMakePoint(
    private val latitude: Float,
    private val longitude: Float,
    private val z: Float? = null,
    private val m: Float? = null
) : Function<String>(GeomColumnType()) {

    override fun toQueryBuilder(queryBuilder: QueryBuilder) {
        queryBuilder.append("ST_MakePoint(", longitude.toString(), ",", latitude.toString())
        z?.let { queryBuilder.append(",", it) }
        m?.let { queryBuilder.append(",", it) }
        queryBuilder.append(")")
    }
}