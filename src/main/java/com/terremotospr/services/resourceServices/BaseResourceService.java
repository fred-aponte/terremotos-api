package com.terremotospr.services.resourceServices;

import com.terremotospr.beans.resourceBeans.BaseResourceBean;
import com.terremotospr.database.entities.resourceEntities.BaseResource;
import com.terremotospr.database.repositories.resourceRepositories.BaseResourceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
 * @author Wilfredo Aponte Pomales
 */
@Service
public class BaseResourceService {
    @Autowired
    BaseResourceRepository baseResourceRepository;

    public Boolean addMedicalDevice(BaseResourceBean bean){
        if(bean == null) return false;

        BaseResource entity = new BaseResource();
        BeanUtils.copyProperties(bean, entity);
        baseResourceRepository.save(entity);
        return true;

    }

    public List<BaseResourceBean> fetchAllBaseResource(){
        List<BaseResourceBean> resource;

        Iterable<BaseResource> iter = baseResourceRepository.findAll();

        resource = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return resource;
    }

    private BaseResourceBean copyProperties(BaseResource entity){
        BaseResourceBean bean = new BaseResourceBean();
        BeanUtils.copyProperties(entity, bean);
        bean.setMapURL(buildMapUrl(entity.getLongitude().toString(), entity.getLatitude().toString()));
        return bean;
    }

    public List<BaseResourceBean> findAvailable(){
        List<BaseResourceBean> resource;

        Iterable<BaseResource> iter = baseResourceRepository.findAll();

        resource = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return resource;
    }

    public BaseResourceBean findById(Long id) {
        return copyProperties(baseResourceRepository.findById(id).get());
    }

    private static String buildMapUrl(String longitude, String latitude){
        String API_KEY = "9j54O8UY_6UT-st43Eh3F29SblcKXDJf6ESr6Yz5J4U";


        return "https://image.maps.ls.hereapi.com/mia/1.6/mapview?apiKey=" + API_KEY + "&i&c="
                + longitude + "," + latitude + "&h=300&w=400&r=10";
    }

    public List<BaseResourceBean> fetchAvailable() {
        List<BaseResourceBean> resource;

        Iterable<BaseResource> iter = baseResourceRepository.findAllByAvailableIsTrueOrderByName();

        resource = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return resource;
    }

    public List<BaseResourceBean> findByName(String name) {
        List<BaseResourceBean> resource;

        Iterable<BaseResource> iter = baseResourceRepository.findAllByNameEquals(name);

        resource = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return resource;
    }


}
