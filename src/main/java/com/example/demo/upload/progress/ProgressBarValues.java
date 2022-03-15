package com.example.demo.upload.progress;

import org.springframework.ui.Model;

import com.example.demo.upload.progress.values.ProgressValuesForHtml;

public class ProgressBarValues extends ProgressValuesForHtml {
	
	public ProgressBarValues() {		
		setValue(value);
		setValues(values);
	}
	
	public void occurChanged(Model model) {
		model.addAttribute("values", getValues());
	}
}
