
package de.pho.descent.web.config;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author pho
 */
@ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(de.pho.descent.web.auth.GenericExceptionMapper.class);
        resources.add(de.pho.descent.web.auth.PlayerAlreadyExistsExceptionMapper.class);
        resources.add(de.pho.descent.web.auth.PlayerBoundary.class);
        resources.add(de.pho.descent.web.auth.PlayerController.class);
        resources.add(de.pho.descent.web.auth.SecurityFilter.class);
        resources.add(de.pho.descent.web.auth.UserValidationExceptionMapper.class);
        resources.add(de.pho.descent.web.campaign.CampaignBoundary.class);
        resources.add(de.pho.descent.web.hero.HeroBoundary.class);
        resources.add(de.pho.descent.web.map.GameMapBoundary.class);
        resources.add(de.pho.descent.web.session.GameSessionBoundary.class);
    }
    
}
