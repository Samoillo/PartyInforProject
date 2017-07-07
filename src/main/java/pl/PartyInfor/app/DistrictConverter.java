package pl.PartyInfor.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.PartyInfor.entity.District;
import pl.PartyInfor.repository.DistrictRepository;

public class DistrictConverter implements Converter<String, District>{


	@Autowired
	private DistrictRepository districtRepository;

	@Override
	public District convert(String source) {
		District district = districtRepository.findOne((long) Integer.parseInt(source));
		return district;

	}

}
