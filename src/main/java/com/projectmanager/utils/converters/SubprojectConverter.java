package com.projectmanager.utils.converters;

import com.projectmanager.model.view.SubprojectView;
import com.projectmanager.persistence.entity.Subproject;
import org.springframework.stereotype.Component;

@Component
public class SubprojectConverter {

    public SubprojectView convertToSubprojectView(Subproject subproject){
        return SubprojectView.builder().
                name(subproject.getName()).
                build();
    }
}
