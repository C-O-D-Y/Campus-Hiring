package com.campushiring.modelmapping;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campushiring.entity.Options;
import com.campushiring.pojo.OptionsDTO;
import com.campushiring.repositories.OptionsRepo;

@Service
public class ModelMappingDTO {

	@Autowired
	OptionsRepo tr;

	public List<OptionsDTO> gd() {
		try {
			System.out.println("wcwws");
			List<Options> userEntities = tr.findByForeignKey(1);
			// Create Conversion Type
			System.out.println("wcwws");
			java.lang.reflect.Type listType = new TypeToken<List<OptionsDTO>>() {
			}.getType();
			System.out.println("wcwws");
			// Convert List of Entity objects to a List of DTOs objects
			List<OptionsDTO> fd = new ModelMapper().map(userEntities, listType);
			System.out.println("wcwws");
			for (OptionsDTO dto : fd) {
				dto.getOption_id();
			}
			System.out.println("wcwws");
			return fd;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<OptionsDTO>();
	}
}
