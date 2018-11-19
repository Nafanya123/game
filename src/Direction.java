public enum Direction {

    UP("идти на верх"),
    DOWN("идти вниз"),
    WEST("идти на запад"),
    EAST("идти на восток"),
    NORTH("идти на север"),
    SOUTH("идти на юг"),

    LOOK_AROUND("осмотреться"),
    INVENTORY("инвентарь"),


    BUCKET("взять ведро"),
    WHISKEY("взять виски"),
    CHAIN("взять цепь"),
    WIZARD("взять волшебника"),
    BURNENR("взять горелку"),
    WELL("взять колодец"),
    FROG("взять лягушку"),
    DRINK_WHISKEY("выпить виски"),

    USE_BUCKET_AND_CHAIN("использовать цепь на ведро"),
    USE_BUCKET_ON_WELL("использовать ведро на колодец"),
    USE_BUCKET_ON_WIZARD("использовать ведро на волшебника"),

    REPLIC_LIVING_ROOM_ALL_ITEMS("Вы находитесь в гостиной в доме волшебника. " +
                                 "\nА вот и он сам громко храпит на кровати. " +
                                 "\nНа западе от вас есть дверь, рядом лестница " + "наверх. " +
                                 "\nЗдесь находятся: ведро, бутылка виски. "),
    REPLIC_LIVING_ROOM_NOT_BUCKET("Вы находитесь в гостиной в доме волшебника. " +
                                  "\nА вот и он сам громко храпит на кровати. " +
                                  "\nНа западе от вас есть дверь, рядом лестница " + "наверх. " +
                                  "\nЗдесь находятся: бутылка виски. "),
    REPLIC_LIVING_ROOM_NOT_WHISKEY("Вы находитесь в гостиной в доме волшебника. " +
                                   "\nА вот и он сам громко храпит на кровати. " +
                                   "\nНа западе от вас есть дверь, рядом лестница " + "наверх. " +
                                   "\nЗдесь находятся: ведро. "),
    REPLIC_LIVING_ROOM_NOT_ALL("Вы находитесь в гостиной в доме волшебника. " +
                               "\nА вот и он сам громко храпит на кровати. " +
                               "\nНа западе от вас есть дверь, рядом лестница " + "наверх. "),
    REPLIC_GARDEN_ALL_ITEMS("Вы в прекрасном саду. Рядом с вами колодец. " +
                            "\nНа востоке дверь в дом. " +
                            "\nЗдесь находятся: лягушка и цепь. "),
    REPLIC_GARDEN_NOT_CHAIN("Вы в прекрасном саду. Рядом с вами колодец. " +
                            "\nНа востоке дверь в дом. " +
                            "\nЗдесь находятся: лягушка. "),
    REPLIC_ATTIC("Вы на чердаке старого дома. " +
                 "\nВ углу видна гигантская горелка. " +
                 "\nВниз ведет лестница. ");


    private String command;
    Direction(String command)
    {
        this.command = command;
    }

    public String getCommand()
    {
        return command;
    }
}