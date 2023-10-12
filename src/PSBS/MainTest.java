package PSBS;

import PSBS.dls.DepthLimitedSearch;
import PSBS.ucs.UniformCostSearch;
import PSBS.ucs.NodeUCS;

public class MainTest {
    public static void main(String[] args) {

        // Membuat Node dengan nama kota baru
        Node NewYork = new Node("New York");
        Node LosAngeles = new Node("Los Angeles");
        Node Chicago = new Node("Chicago");
        Node Houston = new Node("Houston");
        Node Miami = new Node("Miami");
        Node SanFrancisco = new Node("San Francisco");
        Node Seattle = new Node("Seattle");
        Node Denver = new Node("Denver");

        // Menambahkan tetangga dari setiap kota
        NewYork.addNeighbor(Chicago);
        NewYork.addNeighbor(Miami);
        NewYork.addNeighbor(Houston);

        LosAngeles.addNeighbor(SanFrancisco);
        LosAngeles.addNeighbor(Seattle);

        Chicago.addNeighbor(NewYork);
        Chicago.addNeighbor(Denver);
        Chicago.addNeighbor(LosAngeles);

        Houston.setNeighbor(NewYork);
        Houston.addNeighbor(Miami);

        Miami.addNeighbor(NewYork);
        Miami.addNeighbor(Houston);

        SanFrancisco.addNeighbor(LosAngeles);
        SanFrancisco.addNeighbor(Seattle);

        Seattle.addNeighbor(LosAngeles);
        Seattle.addNeighbor(SanFrancisco);

        Denver.addNeighbor(Chicago);

        // Mencari solusi dari New York ke San Francisco menggunakan BFS, DLS, dan UCS
        System.out.println("BFS");
        PSBS.bfs.BreadthFirstSearch bfs = new PSBS.bfs.BreadthFirstSearch();
        bfs.search(SanFrancisco, NewYork);
        System.out.println();

        System.out.println("DLS");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        dls.setLimit(10);
        dls.search(NewYork, SanFrancisco);
        System.out.println();

        // Membuat NodeUCS dengan nama kota dan biaya
        NodeUCS NewYorkUCS = new NodeUCS(NewYork, 0);
        NodeUCS LosAngelesUCS = new NodeUCS(LosAngeles, 2448);
        NodeUCS ChicagoUCS = new NodeUCS(Chicago, 2013);
        NodeUCS HoustonUCS = new NodeUCS(Houston, 1626);
        NodeUCS MiamiUCS = new NodeUCS(Miami, 1760);
        NodeUCS SanFranciscoUCS = new NodeUCS(SanFrancisco, 0);
        NodeUCS SeattleUCS = new NodeUCS(Seattle, 808);
        NodeUCS DenverUCS = new NodeUCS(Denver, 1771);

        // Menambahkan tetangga dari setiap kota
        NewYorkUCS.addNeighbors(ChicagoUCS);
        NewYorkUCS.addNeighbors(MiamiUCS);
        NewYorkUCS.addNeighbors(HoustonUCS);

        LosAngelesUCS.addNeighbors(SanFranciscoUCS);
        LosAngelesUCS.addNeighbors(SeattleUCS);

        ChicagoUCS.addNeighbors(NewYorkUCS);
        ChicagoUCS.addNeighbors(DenverUCS);
        ChicagoUCS.addNeighbors(LosAngelesUCS);

        HoustonUCS.addNeighbors(NewYorkUCS);
        HoustonUCS.addNeighbors(MiamiUCS);

        MiamiUCS.addNeighbors(NewYorkUCS);
        MiamiUCS.addNeighbors(HoustonUCS);

        SanFranciscoUCS.addNeighbors(LosAngelesUCS);
        SanFranciscoUCS.addNeighbors(SeattleUCS);

        SeattleUCS.addNeighbors(LosAngelesUCS);
        SeattleUCS.addNeighbors(SanFranciscoUCS);

        DenverUCS.addNeighbors(ChicagoUCS);

        // Mencari solusi dari New York ke San Francisco menggunakan UCS
        System.out.println("UCS");
        UniformCostSearch ucs = new UniformCostSearch();
        ucs.search(SanFranciscoUCS, NewYorkUCS);
    }
}


