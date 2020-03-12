package com.campushiring.controllers;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campushiring.customExceptionHandling.ExceptionHandling;
import com.campushiring.entity.Options;
import com.campushiring.pojo.OptionsDTO;
import com.campushiring.services.Services;

@Controller
public class OptionsController {

	@Autowired
	Services qoi;

	public OptionsController() {
		LOG = LoggerFactory.getLogger(OptionsController.class);
	}

	Logger LOG;
	ModelMapper modelMapper = new ModelMapper();

	@GetMapping(path = "/sc/getOptions/{id}")
	@ResponseBody()
	public ArrayList<OptionsDTO> getOptions(@PathVariable(name = "id") Integer id) throws ExceptionHandling {
		try {
			OptionsDTO ty = null;
			ArrayList<OptionsDTO> dto = new ArrayList<OptionsDTO>();

			ArrayList<Options> option = (ArrayList<Options>) qoi.getOptions(id);

			if (option.get(0).getOption_id() == 0) {
				ExceptionHandling.setHttpCode(HttpStatus.NOT_FOUND);
				throw new ExceptionHandling("no content");
			}
			for (Options op : option) {
				ty = new OptionsDTO();
				modelMapper.map(op, ty);
				dto.add(ty);
			}

			LOG.info("Options has been fetched");

			return dto;
		}

		catch (NullPointerException npe) {
			throw new ExceptionHandling("NPE");
		}

		catch (Exception e) {
			e.printStackTrace();
			ExceptionHandling.setHttpCode(HttpStatus.NOT_ACCEPTABLE);
			LOG.error("Exception Came With Code " + HttpStatus.NOT_ACCEPTABLE);
			throw new ExceptionHandling("no content");
		}

	}

}
