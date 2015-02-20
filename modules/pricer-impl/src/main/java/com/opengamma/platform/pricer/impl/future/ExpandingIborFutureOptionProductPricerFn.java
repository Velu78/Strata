package com.opengamma.platform.pricer.impl.future;

import com.opengamma.analytics.financial.provider.description.interestrate.NormalSTIRFuturesProviderInterface;
import com.opengamma.basics.currency.CurrencyAmount;
import com.opengamma.collect.ArgChecker;
import com.opengamma.platform.finance.future.ExpandedIborFuture;
import com.opengamma.platform.finance.future.ExpandedIborFutureOption;
import com.opengamma.platform.finance.future.IborFutureOption;
import com.opengamma.platform.finance.future.IborFutureOptionSecurityTrade;
import com.opengamma.platform.pricer.PricingEnvironment;
import com.opengamma.platform.pricer.future.IborFutureOptionProductPricerFn;

/**
 * Pricer implementation for ibor future option products.
 * <p>
 * The ibor future option product is priced by expanding it.
 */
public class ExpandingIborFutureOptionProductPricerFn
    implements IborFutureOptionProductPricerFn<IborFutureOption> {

  /**
   * Pricer for {@link ExpandedIborFuture}.
   */
  private final IborFutureOptionProductPricerFn<ExpandedIborFutureOption> expandedIborFutureOptionPricerFn;

  /**
   * Creates an instance.
   * 
   * @param expandedIborFutureOptionPricerFn  the pricer for {@link ExpandedIborFutureOption}
   */
  public ExpandingIborFutureOptionProductPricerFn(
      IborFutureOptionProductPricerFn<ExpandedIborFutureOption> expandedIborFutureOptionPricerFn) {
    this.expandedIborFutureOptionPricerFn = ArgChecker.notNull(expandedIborFutureOptionPricerFn,
        "expandedIborFutureOptionPricerFn");
  }

  @Override
  public double price(PricingEnvironment env, IborFutureOption iborFutureOptionProduct,
      NormalSTIRFuturesProviderInterface surface) {
    return expandedIborFutureOptionPricerFn.price(env, iborFutureOptionProduct.expand(), surface);
  }

  @Override
  public CurrencyAmount presentValue(PricingEnvironment env, IborFutureOption iborFutureOptionProduct,
      IborFutureOptionSecurityTrade trade, NormalSTIRFuturesProviderInterface surface) {
    return expandedIborFutureOptionPricerFn.presentValue(env, iborFutureOptionProduct.expand(), trade, surface);
  }

  @Override
  public double priceDelta(PricingEnvironment env, IborFutureOption iborFutureOptionProduct,
      NormalSTIRFuturesProviderInterface surface) {
    return expandedIborFutureOptionPricerFn.priceDelta(env, iborFutureOptionProduct.expand(), surface);
  }

  @Override
  public double priceGamma(PricingEnvironment env, IborFutureOption iborFutureOptionProduct,
      NormalSTIRFuturesProviderInterface surface) {
    return expandedIborFutureOptionPricerFn.priceGamma(env, iborFutureOptionProduct.expand(), surface);
  }

  @Override
  public double priceVega(PricingEnvironment env, IborFutureOption iborFutureOptionProduct,
      NormalSTIRFuturesProviderInterface surface) {
    return expandedIborFutureOptionPricerFn.priceVega(env, iborFutureOptionProduct.expand(), surface);
  }

  @Override
  public double priceTheta(PricingEnvironment env, IborFutureOption iborFutureOptionProduct,
      NormalSTIRFuturesProviderInterface surface) {
    return expandedIborFutureOptionPricerFn.priceTheta(env, iborFutureOptionProduct.expand(), surface);
  }

}
