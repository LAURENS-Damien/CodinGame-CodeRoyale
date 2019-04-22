package com.coderoyale.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SiteUtil {

    private static List<Site> sites = new ArrayList<>();

    public static List<Site> getSites() {
        return SiteUtil.sites;
    }

    public static void setSites(List<Site> sites) {
        SiteUtil.sites = sites;
    }

    public static Site getSite(int siteId) throws NoSiteFoundException {
        Optional<Site> site = sites.stream().filter(siteToFind -> siteToFind.getSiteId() == siteId).findFirst();
        if (site.isPresent()) {
            return site.get();
        } else {
            throw new NoSiteFoundException("Le site numéro : " + siteId + " n'existe pas");
        }
    }
}
