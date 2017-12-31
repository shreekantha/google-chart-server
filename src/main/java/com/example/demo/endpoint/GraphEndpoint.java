/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.endpoint;

import com.example.demo.endpoint.domain.Graph;
import com.example.demo.endpoint.domain.GraphBuilder;
import com.example.demo.endpoint.domain.GraphBuilder.ColumnBuilder;
import com.example.demo.endpoint.domain.GraphBuilder.RowBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author spaneos
 */
@Path("/graph")
@Produces(MediaType.APPLICATION_JSON)
public class GraphEndpoint {

    @GET
    public Graph graphData() {
        return GraphBuilder.title("Internal Assessment Score").addColumn(
                ColumnBuilder.
                columnName("Subjects").columnType("string").createColumn()).
                addColumn(
                        ColumnBuilder.columnName("IA Score").
                        columnType("number").
                        createColumn()).addColumn(ColumnBuilder.columnName(
                        "UE Score").columnType("number").createColumn()).addRow(
                RowBuilder.firstColumnValue(
                        "DS").nextColumnValue(10).nextColumnValue(60).
                createRow()).addRow(RowBuilder.firstColumnValue("ES").
                        nextColumnValue(20).nextColumnValue(60).createRow())
                .build();
    }
}
