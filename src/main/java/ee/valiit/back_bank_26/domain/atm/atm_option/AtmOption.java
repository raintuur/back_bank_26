package ee.valiit.back_bank_26.domain.atm.atm_option;

import ee.valiit.back_bank_26.domain.atm.atm.Atm;
import ee.valiit.back_bank_26.domain.atm.option.Option;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "atm_option")
public class AtmOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "atm_id", nullable = false)
    private Atm atm;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "option_id", nullable = false)
    private Option option;

}