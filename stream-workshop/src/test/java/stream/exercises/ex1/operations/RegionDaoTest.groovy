package stream.exercises.ex1.operations

import spock.lang.Specification

class RegionDaoTest extends Specification {
    RegionDao dao = new RegionDao()

    def "should remove Mazowieckie state"() {
        expect:
            !dao.removeMazowieckie().contains(Region.Wojewodztwo.MAZOWIECKIE)
    }

    def 'should get regions with unemployment higher than 10 percent()'() {
        expect:
            dao.findRegionsWithUnemploymentHigherThan10Percent().forEach { region -> assert region.getStopaBezrobocia() > 10 }
    }

    def 'should group subregions by state'() {
        expect:
            Map<Region.Wojewodztwo, List<Region>> regionMap = dao.groupSubregionByWojewodztwo()
            regionMap.size() == 16
            regionMap.get(Region.Wojewodztwo.ŁÓDZKIE).size() == 5
    }

    def 'should print łódzkie regions'() {
        expect:
            dao.printŁódzkieRegions() == 'Podregiony łódzkie to: łódzki i m. Łódź i piotrkowski i sieradzki i skierniewicki.'
    }

    def 'should get regions with lowest stopa bezrobocia'() {
        expect:
            Region region = dao.getRegionWithLowestStopaBezrobocia()
            region.nazwa == 'm. Poznań'
            region.stopaBezrobocia == 3.2
    }
}
