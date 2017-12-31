/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.endpoint.domain;

import java.util.List;

/**
 *
 * @author spaneos
 */
public class Graph {

    private final String graphTitle;
    private final List<Column> columns;
    private final List<List<Object>> rows;
    private final Option option;

    Graph(String graphTitle, List<Column> columns, List<List<Object>> rows,
            Option option) {
        this.graphTitle = graphTitle;
        this.columns = columns;
        this.rows = rows;
        this.option = option;
    }

    public String getGraphTitle() {
        return graphTitle;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<List<Object>> getRows() {
        return rows;
    }

    public Option getOption() {
        return option;
    }

    @Override
    public String toString() {
        return "Graph{" + "graphTitle=" + graphTitle + ", columns=" + columns + ", rows=" + rows + ", option=" + option + '}';
    }

    public static class Column {

        private final String columnType;
        private final String columnName;

        Column(String type, String name) {
            this.columnType = type;
            this.columnName = name;
        }

        public String getColumnType() {
            return columnType;
        }

        public String getColumnName() {
            return columnName;
        }

        @Override
        public String toString() {
            return "{" + "columnType=" + columnType + ", columnName=" + columnName + '}';
        }

    }

    public static class Option {

        private final int width;
        private final int height;
        private final String backgroundColor;

        Option(int width, int height, String backgroundColor) {
            this.width = width;
            this.height = height;
            this.backgroundColor = backgroundColor;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public String getBackgroundColor() {
            return backgroundColor;
        }

    }

}
