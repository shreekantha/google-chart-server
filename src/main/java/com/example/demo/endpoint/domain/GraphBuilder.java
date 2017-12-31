/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.endpoint.domain;

import com.example.demo.endpoint.domain.Graph.Column;
import com.example.demo.endpoint.domain.Graph.Option;
import java.util.ArrayList;
import java.util.List;

public class GraphBuilder {

    private String graphTitle;
    private List<Column> columns;
    private List<List<Object>> rows;
    private Option option;

    private GraphBuilder() {
    }

    private GraphBuilder(String title) {
        this.graphTitle = title;
    }

    public static GraphBuilder title(String title) {
        return new GraphBuilder(title);
    }

    public GraphBuilder addColumn(Column column) {
        if (this.columns != null && !this.columns.isEmpty()) {
            if (column.getColumnType() != null) {
                this.columns.add(column);
            } else {
                throw new IllegalArgumentException(String.format(
                        "Column name =%s - Column Type =%s :Column Type can't be null",
                        column.getColumnName(), column.getColumnType()));
            }
        } else {
            this.columns = new ArrayList<>();
            this.columns.add(column);
        }
        return this;
    }

    public GraphBuilder addRow(List<Object> row) {
        if (this.rows != null && !this.rows.isEmpty()) {
            this.rows.add(row);
        } else {
            this.rows = new ArrayList<>();
            this.rows.add(row);
        }
        return this;
    }

    public GraphBuilder setOption(Option option) {
        this.option = option;
        return this;
    }

    public Graph build() {
        return new Graph(graphTitle, columns, rows, option);
    }

    /**
     * static inner class ColumnBuilder to build columns for google chart(graph)
     */
    public static class ColumnBuilder {

        private String columnType;
        private final String columnName;

        private ColumnBuilder(String columnName) {
            this.columnName = columnName;
        }

        public static ColumnBuilder columnName(String columnName) {

            return new ColumnBuilder(columnName);
        }

        public ColumnBuilder columnType(String columnType) {
            this.columnType = columnType;
            return this;
        }

        public Column createColumn() {
            //setting default addColumn type to string
            if (columnType == null || columnType.isEmpty()) {
                columnType = "string";
            }
            return new Column(columnType, columnName);
        }

    }

    /**
     * static inner class RowBuilder to build(create) rows for google
     * chart(graph)
     */
    public static class RowBuilder {

        private final List<Object> row;

        private RowBuilder(Object columnValue) {
            this.row = new ArrayList<>();
            this.row.add(columnValue);
        }

        public static RowBuilder firstColumnValue(Object columnValue) {

            return new RowBuilder(columnValue);
        }

        public RowBuilder nextColumnValue(Object columnValue) {
            if (this.row != null && !row.isEmpty()) {
                this.row.add(columnValue);
            } else {
                throw new IllegalArgumentException(String.format(
                        "First Column Value is %s : it can't be null",
                        this.row));
            }
            return this;
        }

        public List<Object> createRow() {
            return this.row;
        }

    }

}
