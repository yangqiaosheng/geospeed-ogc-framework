package org.geospeed.ogc.api.wcs;

import java.util.List;

public interface IOgcWcsDescribeCoverageRequest extends IOgcWcsRequest
{
    public List getCoverages();
}
