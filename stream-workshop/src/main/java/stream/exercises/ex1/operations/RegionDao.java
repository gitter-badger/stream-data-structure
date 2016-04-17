package stream.exercises.ex1.operations;

import java.util.List;
import java.util.Map;

public class RegionDao {
    public List<Region> removeMazowieckie() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        throw new UnsupportedOperationException("Missing implementation");
    }

    public List<Region> findRegionsWithUnemploymentHigherThan10Percent() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        throw new UnsupportedOperationException("Missing implementation");
    }

    public Map<Region.Wojewodztwo, List<Region>> groupSubregionByWojewodztwo() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        throw new UnsupportedOperationException("Missing implementation");
    }

    public String printŁódzkieRegions() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        throw new UnsupportedOperationException("Missing implementation");
    }

    public Region getRegionWithLowestStopaBezrobocia() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        throw new UnsupportedOperationException("Missing implementation");
    }
}
