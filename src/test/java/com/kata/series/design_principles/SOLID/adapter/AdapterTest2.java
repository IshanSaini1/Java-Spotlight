package com.kata.series.design_principles.SOLID.adapter;

//JSON DATA POINT
interface JSON{
	public String jsonData();
}

//XML data point
interface XML{
	public String xmlData();
}

//Data point for JSON
class Datapoint1 implements JSON{

	@Override
	public String jsonData() {
		return """
				"dept":"comp_sci",
				"name":"ishan",
				"id":100
				""";
	}
	
}

//To Convert To XML Adapter
class JsonToXMLAdapter implements XML{
	
	Datapoint1 datapoint1;
	
	public JsonToXMLAdapter() {
		
	}

	@Override
	public String xmlData() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


public class AdapterTest2 {

}
