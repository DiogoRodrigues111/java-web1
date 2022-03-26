package com.example.demo.upload.progress.values;

public class ProgressValuesForHtml implements IProgressValues {

	public int values[];
	
	public int value;
	
	
	
	/**
	 * @return the values
	 */
	public int[] getValues() {
		return values;
	}



	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}



	/**
	 * @param values the values to set
	 */
	public void setValues(int[] values) {
		this.values = values;
	}



	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}



	@Override
	public int valuesChanged() {
		
		return 0;
	}

}