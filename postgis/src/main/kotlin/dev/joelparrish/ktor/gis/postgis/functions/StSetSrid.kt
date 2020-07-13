package dev.joelparrish.ktor.gis.postgis.functions

import dev.joelparrish.ktor.gis.postgis.columns.GeomColumnType
import org.jetbrains.exposed.sql.append
import org.jetbrains.exposed.sql.Expression
import org.jetbrains.exposed.sql.Function
import org.jetbrains.exposed.sql.QueryBuilder

/**
 * Sets the SRID on a geometry to a particular integer value. Useful in constructing bounding boxes for queries.
 *
 * Note: This function does not transform the geometry coordinates in any way - it simply sets the meta data defining
 * the spatial reference system the geometry is assumed to be in. Use ST_Transform if you want to transform the
 * geometry into a new projection.
 */
class StSetSrid<T>(
    private val expr: Expression<T>,
    private val srid: Int
) : Function<String>(GeomColumnType()) {
    override fun toQueryBuilder(queryBuilder: QueryBuilder) =
        queryBuilder { append("ST_SetSRID(", expr, ",", srid.toString(), ")") }
}