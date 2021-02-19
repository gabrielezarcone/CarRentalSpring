package com.zarconeg.carRental.converters;

import com.zarconeg.carRental.domain.Ruolo;
import com.zarconeg.carRental.repository.RuoloDao;
import com.zarconeg.carRental.service.RuoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleSetPropertyEditor extends CustomCollectionEditor {

    @SuppressWarnings("unchecked")
    public RoleSetPropertyEditor(Class<? extends Collection> collectionType) {
        super(collectionType);
    }

}
