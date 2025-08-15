package br.com.etecia.myapp;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    RecyclerView idListadeProdutos;
    List<Produtos> lstProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.lista_produtos_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //criando um array
        lstProdutos = new ArrayList<>();
        lstProdutos.add(new Produtos("UP", R.drawable.cadeiragamer));
        lstProdutos.add(new Produtos("Digit", R.drawable.calculadora));
        lstProdutos.add(new Produtos("Oval", R.drawable.gatorosa));
        lstProdutos.add(new Produtos("Lancheira", R.drawable.lancheira));
        lstProdutos.add(new Produtos("HelloKitty", R.drawable.minisakoarigatok));
        lstProdutos.add(new Produtos("ASUS", R.drawable.notebook));
        lstProdutos.add(new Produtos("Instax", R.drawable.camera));
        lstProdutos.add(new Produtos("Garrafa Rosa", R.drawable.garrafarosa));
        lstProdutos.add(new Produtos("Teclado", R.drawable.teclado));
        lstProdutos.add(new Produtos("Spiral", R.drawable.tesoura));

        idListadeProdutos = findViewById(R.id.idListaProdutos);

        //tipo
        idListadeProdutos.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        //inst
        AdaptadorProdutos adapter = new AdaptadorProdutos(getApplicationContext(), lstProdutos);

        idListadeProdutos.hasFixedSize();

        idListadeProdutos.setAdapter(adapter);





    }
}