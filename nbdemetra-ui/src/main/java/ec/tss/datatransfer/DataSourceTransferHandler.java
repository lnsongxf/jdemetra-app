/*
 * Copyright 2013 National Bank of Belgium
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved 
 * by the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and 
 * limitations under the Licence.
 */
package ec.tss.datatransfer;

import com.google.common.base.Optional;
import ec.tss.tsproviders.DataSource;
import ec.tstoolkit.design.ServiceDefinition;
import java.awt.datatransfer.Transferable;
import javax.annotation.Nonnull;

/**
 * Class that can produce a DataSource from a Transferable. To be used through
 * {@link DataSourceTransferSupport}.
 *
 * @author Philippe Charles
 */
@ServiceDefinition
public abstract class DataSourceTransferHandler {

    /**
     * Checks if this class can handle the specified Transferable.
     *
     * @param t the input data
     * @return
     */
    abstract public boolean canHandle(@Nonnull Transferable t);

    /**
     * Checks if this class can handle the specified Transferable with a
     * specific provider.
     *
     * @param t the input data
     * @param providerName a specific provider name
     * @return
     */
    abstract public boolean canHandle(@Nonnull Transferable t, @Nonnull String providerName);

    /**
     * Retrieve a DataSource from a Transferable.
     *
     * @param t the input data
     * @return an optional DataSource
     * @see #canHandle(java.awt.datatransfer.Transferable)
     */
    @Nonnull
    abstract public Optional<DataSource> getDataSource(@Nonnull Transferable t);

    /**
     * Retrieve a DataSource from a Transferable with a specific provider.
     *
     * @param t the input data
     * @param providerName a specific provider name
     * @return an optional DataSource
     * @see #canHandle(java.awt.datatransfer.Transferable, java.lang.String)
     */
    @Nonnull
    abstract public Optional<DataSource> getDataSource(@Nonnull Transferable t, @Nonnull String providerName);
}
