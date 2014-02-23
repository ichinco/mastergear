package com.mastergear

class WeightParseService {

    def weightParse(String weightString) {
        String[] tokens = weightString.tokenize();
        double total = 0;
        for (int i=1; i< tokens.size(); i+=2) {
            Double value = 0;
            try {
                value = Double.parseDouble(tokens[i-1]);
            } catch (Exception e) {
                System.out.println("cannot parse " + tokens[i-1]);
            }
            switch (tokens[i]){
                case "lb.":
                case "lb":
                case "lbs.":
                case "lbs":
                case "pound":
                case "pounds":
                    total += convertPoundsToOunces(value);
                    break;
                case "ounces":
                case "ounce":
                case "oz.":
                case "oz":
                    total += value;
                    break;
                case "kilogram":
                case "kilograms":
                case "kg":
                case "kg.":
                    total += convertKgToOunces(value);
                    break;
                case "gram":
                case "grams":
                case "g":
                case "g.":
                    total += convertGToOunces(value);
                    break;
                default:
                    System.out.println("cannot handle " + tokens[i]);
                    break;
            }
        }

        return total;
    }

    def convertPoundsToOunces(double pounds) {
        return pounds * 16;
    }

    def convertKgToOunces(double kg){
        return kg * 35.274;
    }

    def convertGToOunces(double g){
        return g * 0.035274;
    }
}
