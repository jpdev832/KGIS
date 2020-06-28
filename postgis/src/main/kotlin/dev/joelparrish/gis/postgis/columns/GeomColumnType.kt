package dev.joelparrish.gis.postgis.columns

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ColumnType
import org.jetbrains.exposed.sql.Table

/**
 * Defines a new postgres column type for GEOMETRY
 */
open class GeomColumnType : ColumnType() {
    override fun sqlType(): String = "GEOMETRY"
}

/**
 * Table extension to register a new table column
 */
fun Table.geom(name: String): Column<String> {
    return registerColumn(name, GeomColumnType())
}