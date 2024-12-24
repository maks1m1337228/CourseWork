package com.example.autosalonapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.
        carsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("Toyota Camry", "30000$", "Седан", R.drawable.ic_launcher_background)); //заменить на реальное изображение
        carsList.add(new Car("Honda Civic", "25000$", "Хэтчбек", R.drawable.ic_launcher_background)); //заменить на реальное изображение
        carsList.add(new Car("Ford Mustang", "50000$", "Спорткар", R.drawable.ic_launcher_background)); //заменить на реальное изображение

CarsAdapter carsAdapter = new CarsAdapter(carsList);
        carsRecyclerView.setAdapter(carsAdapter);
    }

private static class Car {
    String name;
    String price;
    String description;
    int imageResource;

    public Car(String name, String price, String description, int imageResource) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageResource = imageResource;
    }
}

private static class CarViewHolder extends RecyclerView.ViewHolder {
    ImageView carImage;
    TextView carName;
    TextView carPrice;
    TextView carDescription;

    public CarViewHolder(@NonNull View itemView) {
        super(itemView);
        carImage = itemView.findViewById(R.id.car_image);
        carName = itemView.findViewById(R.id.car_name);
        carPrice = itemView.findViewById(R.id.car_price);
        carDescription = itemView.findViewById(R.id.car_description);
    }
}


private static class CarsAdapter extends RecyclerView.Adapter<CarViewHolder> {
    private List<Car> carList;

    public CarsAdapter(List<Car> carList) {
        this.carList = carList;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.carName.setText(car.name);
        holder.carPrice.setText(car.price);
        holder.carDescription.setText(car.description);
        holder.carImage.setImageResource(car.imageResource); // загрузка изображения
    }


    @Override
    public int getItemCount() {
        return carList.size();
    }
}
}
