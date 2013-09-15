package mastergear

class WeightTagLib {

    def weightPrintService

    def weightInLbOz = { attrs, body ->
        out << weightPrintService.getOzInLbOz(attrs.oz);
    }

    def getTotalWeight = {attrs, body ->
        out << weightPrintService.getTotalWeight(attrs.gear);
    }
}
