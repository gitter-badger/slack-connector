/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.slack.metadata;

import org.mule.api.annotations.MetaDataKeyRetriever;
import org.mule.api.annotations.MetaDataRetriever;
import org.mule.api.annotations.components.MetaDataCategory;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.modules.slack.SlackConnector;
import org.mule.modules.slack.client.model.group.Group;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by esteban on 19/02/15.
 */

@MetaDataCategory
public class GroupCategory {

    public SlackConnector getMyconnector() {
        return myconnector;
    }

    public void setMyconnector(SlackConnector myconnector) {
        this.myconnector = myconnector;
    }

    @Inject
    private SlackConnector myconnector;

    @MetaDataKeyRetriever
    public List<MetaDataKey> getEntities() throws Exception {
        List<MetaDataKey> entities = new ArrayList<MetaDataKey>();
        List<Group> groupList = myconnector.slack().getGroupList();
        for(Group group: groupList){
            entities.add(new DefaultMetaDataKey(group.getId(),group.getName() + " - " + group.getId()));
        }

        return entities;
    }
    @MetaDataRetriever
    public MetaData describeEntity(MetaDataKey entityKey) throws Exception {
        return null;
    }
}