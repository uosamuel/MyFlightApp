package com.example.flightapplication

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Composable
fun MyStaggeredGrid(
    modifier: Modifier = Modifier,
    numberOfColumn: Int = 2,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier,
    ) { measurable, constraints ->
        val columnWidth = (constraints.maxWidth / numberOfColumn)
        val itemConstraints = constraints.copy(maxWidth = columnWidth)
        val columnHeight = IntArray(numberOfColumn) { 0 }
        val placeable = measurable.map { measurable ->
            val column = shortTestColumn(columnHeight)
            val placeable = measurable.measure(itemConstraints)
            columnHeight[column] += placeable.height
            placeable
        }

            val height = columnHeight.maxOrNull()?.coerceIn(constraints.minHeight, constraints.maxHeight)?: constraints.minHeight

        layout(
            width = constraints.maxWidth,
            height = height
        ){
            val columnYPointers = IntArray(numberOfColumn) {0}
            placeable.forEach { placeable ->
                val column = shortTestColumn(columnYPointers)

                placeable.place(
                    x = columnWidth * column,
                    y = columnYPointers[column]
                )

                columnYPointers[column] += placeable.height
            }
        }
    }
}

private fun shortTestColumn(columnHeight: IntArray): Int {
    var minHeight = Int.MAX_VALUE
    var columnIndex = 0

    columnHeight.forEachIndexed { index, height ->

        if (height < minHeight) {
            minHeight = height
            columnIndex = index
        }
    }
    return columnIndex
}