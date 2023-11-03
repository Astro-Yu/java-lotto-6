package lotto;

import java.util.ArrayList;
import java.util.List;

public class Cpu {
    private List<Lotto> sixLottoNumbers;
    private List<Integer> bonusNumbers;
    private int tickets;

    public Cpu(int money) {
        validTickets(money);
        this.tickets = money / IntConstants.UNIT_BILL.getValue();
        this.sixLottoNumbers = setSixLottoNumbers(tickets);
        this.bonusNumbers = setBonusNumber(tickets);
    }

    public List<Lotto> getSixLottoNumbers() {
        return sixLottoNumbers;
    }

    public List<Integer> getBonusNumbers() {
        return bonusNumbers;
    }

    public int getTickets() {
        return tickets;
    }

    private List<Lotto> setSixLottoNumbers(int tickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < tickets; i++) {
            lottos.add(new Lotto(LottoGenerator.sixNumber()));
        }
        return lottos;
    }

    private List<Integer> setBonusNumber(int tickets) {
        List<Integer> bonus = new ArrayList<>();
        for (int i = 0; i < tickets; i++) {
            bonus.add(LottoGenerator.bonusNumber());
        }
        return bonus;
    }

    private void validTickets(int money) {
        if (money % IntConstants.UNIT_BILL.getValue() != 0) { // 나머지가 0이 아닐 때 오류 반환
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT_MESSAGE.getMessage());
        }
    }
}
