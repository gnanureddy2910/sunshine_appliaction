package com.dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dl.entity.Attributes;
import com.dl.service.AttributesService;

@RestController
public class AttributeController {

	@Autowired
	private AttributesService attributesService;

	@PostMapping("/addAttributes")
	public Attributes addAttributes(@RequestBody  Attributes attributes) {
		return attributesService.addAttributes(attributes);

	}

	@GetMapping("/getAllAttributes")
	public List<Attributes> getAllAttributes() {
		return attributesService.getAllAttributes();
	}

	@DeleteMapping("/deleteAttributes/{attributeId}")
	public String deleteAttributesById(int attributeId) {

		attributesService.deleteAttributesById(attributeId);
		return "deleted sucessfully";
	}

	@PutMapping("/updateAttributes/{attributeId}")

	public Attributes updateAttributes(int attributeId, Attributes attributes) {

		return attributesService.updateAttributes(attributeId, attributes);
	}

}
