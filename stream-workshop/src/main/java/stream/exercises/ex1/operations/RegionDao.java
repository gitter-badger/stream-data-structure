package stream.exercises.ex1.operations;

import stream.exercises.ex1.operations.Region.Wojewodztwo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegionDao {
    public List<Region> removeMazowieckie() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        list.removeIf(region -> region.getWojewodztwo().equals(Wojewodztwo.MAZOWIECKIE));
        return list;
    }

    public List<Region> findRegionsWithUnemploymentHigherThan10Percent() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        return list.stream()
                .filter(r -> r.getStopaBezrobocia() > 10)
                .collect(Collectors.toList());
    }

    public Map<Region.Wojewodztwo, List<Region>> groupSubregionByWojewodztwo() {
        List<Region> list = Region.RegionRepository.bezrobocie2014();

        return list.stream().collect(Collectors.groupingBy(region -> region.getWojewodztwo()));
    }

    public String printŁódzkieRegions(){
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        return list.stream()
                .filter(region -> region.getWojewodztwo().equals(Region.Wojewodztwo.ŁÓDZKIE))
                .map(Region::getNazwa)
                .collect(Collectors.joining(" i ", "Podregiony łódzkie to: ", "."));
    }

    public Region getRegionWithLowestStopaBezrobocia(){
        List<Region> list = Region.RegionRepository.bezrobocie2014();
        return list.stream().reduce((a, b) -> a.getStopaBezrobocia() > b.getStopaBezrobocia() ? b : a).get();
    }
}
