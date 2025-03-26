package com.example.trailguide

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryFragment : Fragment() {

    private lateinit var trailList: List<Trail>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        val category = arguments?.getString("category")
        trailList = getTrailsForCategory(category)

        val adapter = TrailAdapter(trailList) { trail ->
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("trail_name", trail.name)
            intent.putExtra("trail_description", trail.description)
            intent.putStringArrayListExtra("trail_stages", ArrayList(trail.stages))
            intent.putExtra("trail_image", trail.imageResId)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        return view
    }

    private fun getTrailsForCategory(category: String?): List<Trail> {
        return when (category) {
            "Tatry" -> listOf(
                Trail("Na Giewont przez Dolinę Małej Łąki", R.drawable.giewont, "Masyw Giewontu stanowi symbol Zakopanego. Nic więc dziwnego, że szczyt w porze letniej przeżywa prawdziwe oblężenie. W opinii wielu tatrzańskich pasjonatów najlepiej wejść na \"Śpiącego Rycerza\" od strony Doliny Małej Łąki, która jest po prostu przepiękna, szczególnie jesienią.", listOf("Gronik (930 m) - Wielka Polana Małołącka (1170 m)", "Wielka Polana Małołącka (1170 m) - Przełęcz Kondracka (1723 m)", "Przełęcz Kondracka (1723 m) - Kondracka Przełęcz Wyżnia (1765 m) - Giewont (1894 m)")),
                Trail("Na Kasprowy Wierch z Kuźnic przez Myślenickie Turnie", R.drawable.kasprowy, "Trasa na Kasprowy Wierch z Kuźnic należy do jednych z najłatwiejszych w polskich Tatrach. Jest monotonna i chwilami wręcz nudna, wszelako polecam ją z uwagi na brak dużego zatłoczenia szczególnie w okresie zimowym (duża część ludzi po prostu wjeżdża kolejką na szczyt). Ponadto stanowi wspaniałe miejsce do treningu dla biegaczy.", listOf("Kuźnice (1010 m) - Myślenickie Turnie (1352 m)", "Myślenickie Turnie (1352 m) - Kasprowy Wierch (1985 m)")),
                Trail("Droga pod Reglami", R.drawable.regle, "Spacerowy szlak pod kilkoma wzniesieniami reglowymi (stąd nazwa). Dzięki temu, że rozciąga się poza granicami Tatrzańskiego Parku Narodowego, dopuszczalna jazda rowerem. Co więcej, nie musimy uiszczać żadnych opłat. Droga pod Reglami wiedzie prawie 7,5 km przez zalesione wzgórza, dlatego też podziwiać możemy jedynie panoramę Zakopanego i Pasma Gubałowskiego. Tatry Zachodnie, a tym bardziej Tatry Wysokie całkowicie zakryte. Trasę można również przejechać rowerem.\n" +
                        "\n" +
                        "Wycieczkę rozpoczynamy spod \"Księżówki\" w Kuźnicach, która znajduje się naprzeciwko przystanku \"Murowanica\" (po drugiej stronie ulicy). Naturalnie można wyruszyć także z Siwej Polany na peryferiach Doliny Chochołowskiej, aczkolwiek poniżej zostanie przedstawione przejście tylko z pierwszej wspomnianej strony.", listOf("Murowanica (941 m) - Dolina Białego (910 m)", "Dolina Białego (910 m) - Wylot ku Dziurze (900 m) - ul. Strążyska (930 m)", "ul. Strążyska (930 m) - Wylot za Bramką (934 m) - Gronik (930 m)", "Gronik (930 m) - Nędzówka (952 m) - Kiry (927 m)", "Kiry (927 m) - Polana Biały Potok (930 m) - Siwa Polana (925 m)")),
                Trail("Nad Morskie Oko z Doliny Pięciu Stawów Polskich przez Szpiglasową Przełęcz", R.drawable.morskieoko, "Trasa pomiędzy tymi schroniskami niezwykle popularna i przyjemna. Stosunkowo łatwa do przejścia latem, jednakże zimą może okazać się nadzwyczaj niebezpieczna z powodu dużego prawdopodobieństwa zejścia lawiny, a także oblodzenia skał.", listOf("Schronisko w Dolinie Pięciu Stawów Polskich (1671 m) - Tablica S. Bronikowskiego (1740 m)", "Tablica S. Bronikowskiego (1740 m) - Szpiglasowa Przełęcz (2110 m)", "Szpiglasowa Przełęcz (2110 m) - Dolina za Mnichem (1785 m) - Morskie Oko (1395 m)")),
                Trail("Na Rysy", R.drawable.rysy, "Szlak na najwyższy szczyt Polski w okresie letnim jest bardzo tłumnie odwiedzany z uwagi na wspaniałą panoramę Tatr we wszystkie strony, a i fakt, że nie należy do najtrudniejszych (porównując z Orlą Percią i trasą na Mięguszowiecką Przełęcz pod Chłopkiem), choć oczywiście na wycieczkę na Rysy nie powinni decydować się niedoświadczeni turyści. Co więcej, podejście wymaga również nie lada kondycji.", listOf("Morskie Oko (1395 m) - Czarny Staw pod Rysami (1580 m)", "Czarny Staw pod Rysami (1580 m) - Rysy (2499 m)"))
                )
            "Sudety" -> listOf(
                Trail("Pętla z Karpacza do Samotni i Białego Jaru", R.drawable.samotnia, "Szlak, który zaprowadzi nas do najpiękniej położonego karkonoskiego schroniska i na miejsce największej zimowej tragedii w Karkonoszach.", listOf("Karpacz  Biały Jar – Polana", "Polana – Kozi Mostek", "Kozi Mostek – Schronisko Samotnia", "Schronisko Samotnia – Schronisko Strzecha Akademicka", "Akademicka – Biały Jar", "Biały Jar – Karpacz Biały Jar")),
                Trail("Z Zieleńca na Orlicę i do Masarykovej chaty", R.drawable.chata, "Relaksujący spacer na Orlicę (Korona Gór Polski), w trakcie którego towarzyszyć nam będą piękne panoramy pasm otaczających Kotlinę Kłodzką.\n" +
                        "\n" +
                        "Zimą Zieleniec pęka w szwach - ale czemu nie przyjechać tu wiosną, latem bądź jesienią? Wędrówka po płaskiej wierzchowinie głównego grzbietu Gór Orlickich to czysta przyjemność, a perspektywa podziwiania widoków z 25-metrowej wieży na Orlicy i odpoczynku w Masarykovej chacie jeszcze ją wzbogacą...", listOf("Zieleniec (węzeł szlaków przy schronisku PTTK „Orlica”) - Orlica", "Orlica - Šerlich", "Šerlich - Masarykova chata")),
                Trail("Wielka Sowa pętlą z Przełęczy Walimskiej", R.drawable.sowa, "Rodzinna trasa na Wielką Sowę - najwyższy szczyt Gór Sowich, zaliczany do Korony Gór Polski. Masyw Wielkiej Sowy stanowi najatrakcyjniejszą część całego pasma. Większość szlaku przebiega przez urozmaicony gatunkowo las: buki, świerki, brzozy, a pod samym szczytem rosną sosny i kosodrzewina. Na polanie szczytowej usytuowana jest kamienna wieża widokowa, z której można podziwiać jedne z najpiękniejszych górskich panoram Sudetów.", listOf("Przełęcz Walimska parking (762 m n.p.m.) - Wroniec (835 m n.p,m.)", "Wroniec (835 m n.p,m.) - Rozdroże pomiędzy Sowami (961 m n.p.m.)", "Rozdroże pomiędzy Sowami (961 m n.p.m.) - Wielka Sowa (1015 m n.p.n.)", "Wielka Sowa (1015 m n.p.n.) - Mała Sowa (972 m n.p.n.)", "Mała Sowa (972 m n.p.n.) - Jelenia Polana (815 m n.p.m.)", "Jelenia Polana (815 m n.p.m.) - Przełęcz Walimska parking (762 m n.p.m.)"))

                )
            else -> emptyList()
        }
    }

    companion object {
        fun newInstance(category: String): CategoryFragment {
            val fragment = CategoryFragment()
            val args = Bundle()
            args.putString("category", category)
            fragment.arguments = args
            return fragment
        }
    }
}