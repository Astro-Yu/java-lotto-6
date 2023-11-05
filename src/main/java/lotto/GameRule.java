package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Constants.PrizeMoney;

public class GameRule {

    LottoCounter lottoCounter = new LottoCounter();

    public List<Integer> calculateResult(Cpu cpuLottos, Player playerLotto) {
        List<Integer> resultList = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        List<Lotto> cpuSixNumbers = cpuLottos.getSixLottoNumbers();

        for (int index = 0; index < cpuLottos.getTickets(); index++) {
            Lotto cpuSixNumber = cpuSixNumbers.get(index);
            Lotto playerNumber = playerLotto.getSixNumbers();
            int result = lottoCounter.countElement(cpuSixNumber.getNumbers(), playerNumber.getNumbers());
            lottoCounter.hitThree(resultList, result);
            lottoCounter.hitFour(resultList, result);
            lottoCounter.hitFive(resultList, result, cpuSixNumber.getNumbers(), playerLotto.getBonusNumber());
            lottoCounter.hitFiveBonus(resultList, result, cpuSixNumber.getNumbers(), playerLotto.getBonusNumber());
            lottoCounter.hitSix(resultList, result);
        }
        return resultList;
    }

    public String calculateProfit(int inputMoney, List<Integer> gameResult) {
        int income = 0;
        PrizeMoney[] prizeMonies = PrizeMoney.values();
        for (int index = 0; index < gameResult.size(); index++) {
            income += gameResult.get(index) * prizeMonies[index].getMoney();
        }
        double result = (double) income * 100 / inputMoney;
        return String.format("%.1f", result);
    }
}
