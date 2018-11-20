public class Player {

    private Location location;
    private boolean sobriety = true;
    private Inventory inventory = new Inventory();
    private Combo combo = new Combo();

    Player(Location location)
    {
        this.location = location;
        System.out.println(location.getDespcription());
    }

    public void use(String str)
    {
        if(inventory.find(updateNameObject(str)) && inventory.find(updateNameObjectTwo(str)))
        {
            combo.craft(inventory.findItem(updateNameObject(str)), inventory.findItem(updateNameObjectTwo(str)),
                    location.findItem("Горелка"), inventory);
        }
        else if(location.find("Колодец") && inventory.find(updateNameObject(str)))
        {
            combo.craft(inventory.findItem(updateNameObject(str)),
                        location.findItem("Колодец"), inventory, location.getInventory());
        }
        else if(location.find("Волшебник") && inventory.find(updateNameObject(str)))
        {
            combo.craft(inventory.findItem(updateNameObject(str)),
                        location.findItem("Волшебник"), inventory, location.getInventory());
        }
        else if(str.equals(Direction.DRINK_WHISKEY.getCommand()))
        {
            str = str.replace("выпить ", "");
            str = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
            if(inventory.find(str))
            {
                System.out.println("Вы напились");
                sobriety = false;
            }
        }
        else
        {
            System.out.println("что то не то");
        }
    }

    //открыть инвентарь игрока
    public void invent()
    {
        inventory.show();
    }

    private void searchAvailableItems(String name)
    {
        if(location.find(updateName(name)))
        {
            updateItems(updateName(name));
        }
        else
        {
            System.out.println(updateName(name) + " тут не найдено)");
        }
    }
    public void take(String name)
    {
        if(name.equals(Direction.BUCKET.getCommand()))
        {
            searchAvailableItems(name);
        }
        else if(name.equals(Direction.CHAIN.getCommand()))
        {
            searchAvailableItems(name);
        }
        else if(name.equals(Direction.WHISKEY.getCommand()))
        {
            searchAvailableItems(name);
        }
        else if(name.equals(Direction.WIZARD.getCommand()))
        {
            searchAvailableItems(name);
        }
        else if(name.equals(Direction.WELL.getCommand()))
        {
            searchAvailableItems(name);
        }
        else if(name.equals(Direction.BURNENR.getCommand()))
        {
            name = updateName(name);
            name = name.substring(0, 6) + 'а';

            searchAvailableItems(name);
        }
        else
        {
            System.out.println("такой вещи не существует");
        }
    }
    public void lookAround()
    {
        System.out.print(location.getDespcription());
    }

    public void go(String route)
    {
        direction(route);
        lookAround();
    }

    //проверка, если коллекция дает добро на выбранное направление,
    //то плеер перемещается на другую локацию
    private void fineRoute(Direction direction)
    {
        location = location.executeDirection(direction, location);
    }
    //проверяет, совпадает ли введеная команда
    //на переход в другую локацию
    private void direction(String route)
    {
        if(route.equals(Direction.UP.getCommand()))
        {
            fineRoute(Direction.UP);
        }
        else if(route.equals(Direction.DOWN.getCommand()))
        {
            fineRoute(Direction.DOWN);
        }
        else if(route.equals(Direction.WEST.getCommand()))
        {
            fineRoute(Direction.WEST);
        }
        else if(route.equals(Direction.EAST.getCommand()))
        {
            fineRoute(Direction.EAST);
        }
        else
            System.out.println("Вы не можете туда идти.");
    }

    //провеить перемещается ли вещь
    private void updateItems(String name)
    {
        if(location.findItem(name).getMoveable().equals(Moveable.MOBILE))
        {
            inventory.add(new Item(name, Moveable.MOBILE, location.findItem(name).getProperties()));
            location.remove(location.findItem(name));
            System.out.println("Подобрано: " + inventory.findItem(name).getProperties());
        }
        else
        {
            System.out.println(name + " не сможет поместиться к вам в сумку");
        }
    }

    //удаляет первое слово
    private String updateName(String name)
    {
        name = name.replace("взять ", "");
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    }

    //удаляет последнюю буку а, для волшебника
    private String updateLastChar(String command)
    {
        if (command != null && command.length() > 0 && command.charAt(command.length() - 1) == 'а') {
            command = command.substring(0, command.length() - 1);
        }
        return command;
    }

    //удаляет первое слово и вырезает первую вещь
    private String updateNameObject(String name)
    {
        name = name.replace("использовать ", "");
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        name = name.split(" ")[0];
        return name;
    }

    //удаляет до 3 пробела
    private String updateNameObjectTwo(String name)
    {
        name = name.split(" ")[3];
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    }

    public boolean isSobriety() {
        return sobriety;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
