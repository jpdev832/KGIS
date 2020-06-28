package dev.joelparrish.gis.postgis.functions

import org.jetbrains.exposed.sql.Expression
import org.jetbrains.exposed.sql.Op
import org.jetbrains.exposed.sql.QueryBuilder

/**
 * Returns TRUE if geometry A is completely inside geometry B. For this function to make sense, the source geometries
 * must both be of the same coordinate projection, having the same SRID. It is a given that if ST_Within(A,B) is true
 * and ST_Within(B,A) is true, then the two geometries are considered spatially equal.
 */
class StWithin<T, S : T>(
    private val expr1: Expression<T>,
    private val expr2: Expression<S>
) : Op<Boolean>() {
    override fun toQueryBuilder(queryBuilder: QueryBuilder) =
        queryBuilder { append("ST_Within(", expr1, ",", expr2, ")") }
}
