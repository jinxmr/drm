package com.ddl.web.elastic.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "item", type = "docs")
public class Item {

	@Id
	private String id;

	@Field(type = FieldType.Text, analyzer = "ik_max_word")
	private String title;

	@Field(type = FieldType.Keyword)
	private String category;

	@Field(type = FieldType.Keyword)
	private String brand;

	@Field(type = FieldType.Double)
	private Double price;

	private String content;
}
