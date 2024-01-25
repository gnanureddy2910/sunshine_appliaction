package com.dl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.entity.Attributes;
import com.dl.repository.AttributeRepository;

@Service
public class AttributesService {

	@Autowired
	private AttributeRepository attributeRepo;

	public Attributes addAttributes( Attributes attributes) {
		return attributeRepo.save(attributes);
	}

	public List<Attributes> getAllAttributes() {

		return attributeRepo.findAll();
	}

	public Attributes deleteAttributesById(int attributeId) {

		Optional<Attributes> optionalUser = attributeRepo.findById(attributeId);

		if (optionalUser.isPresent()) {
			Attributes attributes = optionalUser.get();
			attributes.setActive(false);

			return attributeRepo.save(attributes);

		} else {

			throw new RuntimeException("Attribute not found with id: " + attributeId);
		}
	}

	public Attributes updateAttributes(int attributeId, Attributes attributes) {

		Attributes existingAttributes = attributeRepo.findById(attributeId).get();
		existingAttributes.setAttributeName(attributes.getAttributeName());

		return attributeRepo.save(existingAttributes);
	}
}
