package mastergear

class WeightTagLib {

    def weightPrintService

    def weightInLbOz = { attrs, body ->
        out << weightPrintService.getOzInLbOz(attrs.oz);
    }

    def getTotalWeight = {attrs, body ->
        def weights = attrs.gear.collect {
            it.weight
        }

        def sum = 0D;
        weights.each {
            sum += it;
        }

        out << weightPrintService.getOzInLbOz(sum);
    }
}
