/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.providermanagement.fragment.controller;

import org.openmrs.Person;
import org.openmrs.module.providermanagement.Provider;
import org.openmrs.module.providermanagement.ProviderManagementGlobalProperties;
import org.openmrs.module.providermanagement.ProviderManagementWebUtil;
import org.openmrs.module.providermanagement.exception.PersonIsNotProviderException;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.openmrs.ui.framework.page.PageModel;

public class ProviderViewFragmentController {

    public void controller(PageModel sharedPageModel, FragmentModel model,
                           @FragmentParam(value = "person", required = false) Person personParam,
                           @FragmentParam(value = "personId", required = false) Integer personId)
                    throws PersonIsNotProviderException{

        // TODO: fix this so that it does't need to fetch the provider?

        // utility methods fetch the person and provider, throwing exceptions if needed
        Person person = ProviderManagementWebUtil.getPerson(sharedPageModel, personParam, personId);
        Provider provider = ProviderManagementWebUtil.getProvider(person);

        // add the person and the provider to the module
        model.addAttribute("person", person);
        model.addAttribute("provider", provider);

        // also add the person attribute types we want to display
        model.addAttribute("personAttributeTypes", ProviderManagementGlobalProperties.GLOBAL_PROPERTY_PERSON_ATTRIBUTE_TYPES());
    }
}
